/*-
 * This computer program is the confidential information and proprietary trade
 * secret of Cisco Systems, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and Cisco Systems,
 * Inc., and receipt or possession does not convey any rights to divulge,
 * reproduce, or allow others to use this program without specific written
 * authorization of Cisco Systems, Inc.
 * 
 * Copyright 2011-2013 Cisco Systems, Inc. All rights reserved.
 * 
 * Created on Oct 8, 2013
 */
package graph;

/*********************
 *                   
 *  Check the graphLinked Package. That is the right one. This is more of abstract class.
 * 
 *********************/

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Collections;

/**
 * This class is for the representation of graphs.
 */

//   A Vertex class is provided as an inner class in order
// to make it mutable but prohibit unauthorized access.
//   Thus in applications, vertices must be referred to by name
// rather than directly, or by number.
//   Vertices are given an effectively private numbering in
// the graph, beginning with 0.

public class Graph {

    // the number of vertices in the graph

    private int numberOfVertices = 0;

    // a list of the vertices in the graph,
    //   in order of vertex number
    // The name of a vertex with a given number may be obtained
    //   indirectly from this list, by first finding the vertex
    //   itself

    private ArrayList vertices = new ArrayList();

    // A hash map for retrieving vertex numbers from names

    private HashMap hm = new HashMap();

    // a list of the adjacency lists in the graph,
    //   in order of vertex number
    // The adjacency lists are lists of vertices.

    private ArrayList adjacencyLists = new ArrayList();

    /**
     * Constructor for a graph, given the list of vertex names
     * 
     * @param vertexNames
     *            a list of the names of the vertices The list entries are converted to strings, with second and subsequent
     *            occurrences of the same string ignored. A graph without vertices or edges is constructed if the input list is
     *            null.
     */

    public Graph(List vertexNames) {
        if (vertexNames != null) {
            Iterator it = vertexNames.iterator();
            while (it.hasNext()) {
                adjacencyLists.add(new LinkedList());
                String name = it.next().toString();

                // check for duplicate vertex names
                if (!hm.containsKey(name)) {
                    Vertex v = new Vertex(numberOfVertices, name);
                    numberOfVertices++;
                    vertices.add(v);
                    hm.put(name, v);
                }
            }
        }
    }

    /**
     * Add an edge to the graph, if both arguments are names of vertices in the graph. Do nothing if one or both arguments are
     * not names of vertices in the graph.
     * 
     * @param s1
     *            the name of the source vertex
     * @param s2
     *            the name of the destination vertex
     */
    // If either argument is not the name of a vertex in the
    //   graph, then a null argument will be passed and caught by
    //   the private "addEdge" method.
    // Note that the cast to the Vertex class is safe.

    public void addEdge(String s1, String s2) {
        addEdge((Vertex) hm.get(s1), (Vertex) hm.get(s2));
    }

    /**
     * Add an edge to the graph, if both arguments are nonnull. Do nothing if one or both arguments are null.
     * 
     * @param v
     *            the source vertex
     * @param w
     *            the destination vertex
     */

    private void addEdge(Vertex v, Vertex w) {
        if (v != null && w != null)
            ((LinkedList) adjacencyLists.get(v.getNumber())).add(w);
    }

    /**
     * Perform a topological sort on the graph.
     * 
     * @return list of vertex names in topological order
     * @throws IllegalArgumentException
     *             if there's no topological sort. This exception will be thrown iff the input contains a cycle The message
     *             value for this exception contains a list of vertices that contain a cycle.
     */
    // The basic algorithm is from Weiss, Section 9.2.
    // After initializing the indegree of each vertex and
    //   a queue q that keeps track of vertices with indegree 0,
    // repeatedly
    //   delete it from the queue
    //   give it a topological sort number
    //   and decrement
    // until the queue becomes empty
    // if all vertices have been numbered (successful case)
    //   return a list of vertex names, sorted by this numbering
    // otherwise throw an exception that provides
    //   a list of the unconsidered vertex names -- there will
    //   be a cycle among these vertices

    // Note that if the method returns a solution, it will assign
    //   each vertex a new topNumber, overwriting any old topNumbers
    //   from its past invocations.  And if there is no solution,
    //   the method won't look at these values.  So the topNumbers
    //   of the vertices needn't be (re)initialized.

    public List topsort() {
        LinkedList q = new LinkedList();
        int counter = 0;
        Iterator it = vertices.iterator();

        // initialize the indegrees

        while (it.hasNext()) {
            Vertex v = (Vertex) it.next();
            List adjacentVertices =
                    (List) adjacencyLists.get(v.getNumber());
            Iterator it2 = adjacentVertices.iterator();
            while (it2.hasNext()) {
                Vertex w = (Vertex) it2.next();
                w.indegree++;
            }
        }

        // initialize the queue of vertices with indegree 0

        it = vertices.iterator();
        while (it.hasNext()) {
            Vertex v = (Vertex) it.next();
            if (v.indegree == 0)
                q.add(v);
        }

        // repeatedly delete vertices with indegree 0
        //   and update the queue

        while (!q.isEmpty()) {
            Vertex v = (Vertex) q.removeFirst();
            v.topNumber = ++counter;
            List adjacentVertices =
                    (List) adjacencyLists.get(v.getNumber());
            it = adjacentVertices.iterator();
            while (it.hasNext()) {
                Vertex w = (Vertex) it.next();
                w.indegree--;
                if (w.indegree == 0)
                    q.add(w);
            }
        }

        // successful case -- all vertices have been numbered,
        //   so construct & return a list of their names,
        //     sorted by this numbering

        if (counter == numberOfVertices) {
            LinkedList output = new LinkedList();
            Collections.sort(vertices);
            it = vertices.iterator();
            while (it.hasNext())
                output.add(((Vertex) it.next()).getName());
            return output;
        }

        // unsuccessful case --  throw an exception whose message
        //   gives a list of vertices that contains a cycle

        else {
            StringBuffer badVertexNames = new StringBuffer(
                    "Bad input!  a cycle exists among the following vertices: ");
            it = vertices.iterator();
            while (it.hasNext()) {
                Vertex v = (Vertex) it.next();
                if (v.indegree > 0)
                    badVertexNames.append(v.getName() + " ");
            }
            throw new IllegalArgumentException(
                    badVertexNames.toString());
        }
    }

    /**
     * An inner class to represent vertices in a graph
     */
    //  Adjacency information is assumed to be stored in the
    //    graph itself.  Vertices are assumed to be numbered
    //    (to have indices) to facilitate storage by the graph
    //    of adjacency lists or matrices
    //  Following Weiss, the topological number of a vertex
    //    is stored in the vertex itself, as the value of
    //    the "topNumber" field.  This field is made public
    //    and provided with a dummy initial value so that
    //    a topological sort method can modify it.

    private class Vertex implements Comparable {

        /**
         * a dummy number for topological ordering
         */
        public int DUMMY_TOP_NUMBER = -1;

        // index for adjacency lists & matrices
        private int number = 0;

        /**
         * the number of vertices to which this vertex is adjacent. This value is designed for use by a topological sort method
         * and thus should not be interpreted as a true indegree outside (or even inside) the context of this method.
         */
        public int indegree;

        /**
         * numbering in a topological ordering
         */
        public int topNumber = DUMMY_TOP_NUMBER;

        // the name used to refer to this vertex in applications
        private String name;

        /**
         * @param num
         *            the index to be used for adjacency lists & matrices
         * @param nm
         *            the name by which this vertex is to be known
         */

        public Vertex(int num, String nm) {
            number = num;
            name = nm;
            indegree = 0;
        }

        /**
         * Compares two vertices by their topological number
         * 
         * @return -1 if this vertex has a lower topological number than o +1 if this vertex has a higher topological number 0
         *         if their topological numbers are equal (iff this vertex is equal to the vertex <code>o</code>)
         */

        public int compareTo(Object o) {
            return topNumber - ((Vertex) o).topNumber;
        }

        /**
         * @return the index of a given vertex, as given in the constructor
         */

        public int getNumber() {
            return number;
        }

        /**
         * @return the index of a given vertex, as given in the constructor
         */

        public String getName() {
            return name;
        }

    } // end of inner class Vertex

} // end of class Graph

