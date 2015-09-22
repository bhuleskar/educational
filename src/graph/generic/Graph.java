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
package graph.generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * This is more of Graph.java, except that am using a java Linked List instead
 * of custom class Neighbor. * Custom Array [] - > java LinkedList. ----
 * __________ ___________ ! ! -> !__!__!___! -> !__!__!___! ----
 * 
 * @author sridhar
 *
 */

public class Graph {
	Vertex[] adjVertexLists;
	boolean directed;
	String file;
	Edge[] adjEdgeLists;
	
	public Graph(String file) throws FileNotFoundException {
		this.file = file;
		readGraphInputFile();
	}

	/**
	 * Read input from the file.
	 * @throws FileNotFoundException
	 */
	private void readGraphInputFile() throws FileNotFoundException {
		Scanner sc = null;
		sc = new Scanner(new File(file));
		setIsDirected(sc.next());

		adjVertexLists = new Vertex[sc.nextInt()];

		// read vertices
		for (int v = 0; v < adjVertexLists.length; v++) {
			adjVertexLists[v] = new Vertex(sc.next(), null, v);
		}

		/* read edges */
		while (sc.hasNext()) {
			/* read vertex names and translate to vertex numbers. */
			
			int vertex1 = indexForName(sc.next());
			/* A vertex may or may not be connected. i.e disjoint graph */
			int vertex2 = -1;
			if (sc.hasNext()) {
				vertex2 = indexForName(sc.next());
			}
			
			Edge edge = new Edge(vertex1,vertex2);
			/*
			 * Because the order doesn't matter, we are addding to the front of the
			 * list. This saves us traversing through linkedList. add v2 to
			 * front of v1's adjacency list and add v1 to front of v2's
			 * adjacency list
			 */
			if (adjVertexLists[vertex1].neighborList == null) {
				adjVertexLists[vertex1].neighborList = new LinkedList<Vertex>();
			}
			if (vertex2 != -1) {
				adjVertexLists[vertex1].neighborList.add(adjVertexLists[vertex2]);
			}
			
			if (!directed && vertex2 != -1) {
				if (adjVertexLists[vertex2].neighborList == null) {
					adjVertexLists[vertex2].neighborList = new LinkedList<Vertex>();
				}
				adjVertexLists[vertex2].neighborList.add(adjVertexLists[vertex1]);
			}
		}
		if (sc != null) {
			sc.close();
		}
	}
	
	/**
	 * Mark if a given graph is directed.
	 * @param next
	 */
	private void setIsDirected(String next) {
		if (next.equals("undirected")) {
			directed = false;
		}
	}

	public boolean isDirected() {
		return directed;
	}

	/**
	 * Index to name mapping.
	 * 
	 * @param name
	 * @return index number.
	 */
	private int indexForName(String name) {
		for (int i = 0; i < adjVertexLists.length; i++) {
			if (adjVertexLists[i].name.equals(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Print the graph.
	 */
	public void printGraphAdjancecyList() {
		System.out.println();
		for (int v = 0; v < adjVertexLists.length; v++) {
			System.out.print(adjVertexLists[v].name);
			for (int i = 0; i < adjVertexLists[v].neighborList.size(); i++) {
				System.out.print(" --> " + adjVertexLists[v].neighborList.get(i).name);
			}
			System.out.println("\n");
		}
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter graph input file name: ");
		String file = sc.nextLine();
		Graph graph = new Graph(file);
		sc.close();
		graph.printGraphAdjancecyList();
		graph.dfs();
		graph.bfs();
	}

	private void dfs() {
		System.out.print("Depth First Search: ");
		Stack<Vertex> s = new Stack<Vertex>();
		s.push(adjVertexLists[0]);
		while (!s.isEmpty()) {
			Vertex v = s.pop();
			if (!v.getIsVisited()) {
				System.out.print(" " + v.name);
				v.setIsVisited(true);
			}
			for (int i = 0; i < v.neighborList.size(); i++) {
				if (!(v.neighborList.get(i)).getIsVisited()) {
					s.push(v.neighborList.get(i));
				}
			}
		}

		for (int i = 0; i < adjVertexLists.length; i++) {
			adjVertexLists[i].setIsVisited(false);
		}
	}

	private void bfs() {
		System.out.print("\n");
		System.out.println("Breadth First Search: ");
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(adjVertexLists[0]);
		while (!q.isEmpty()) {
			Vertex v = q.remove();
			if (!v.getIsVisited()) {
				System.out.print(" " + v.name);
				v.setIsVisited(true);
			}
			for (int i = 0; i < v.neighborList.size(); i++) {
				if (!(v.neighborList.get(i)).getIsVisited()) {
					q.add(v.neighborList.get(i));
				}
			}
		}

	}
}