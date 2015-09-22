package graph.customgraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
 
/**
 * This uses a custom link list kind of structure. More of class Node{ } kind.
 * Use this class for weighted graph. This is very similar to the one in generic
 * package but is more customized to suit weighted graph.
 * 
 * @author sridhar
 * 
 */
  
/*- Adjacency list Representation.
* Custom Array [] - > Custom LinkedList.
*  ----       __________     ___________
*  !   ! ->   !__!__!___! -> !__!__!___!
*  ----
*
*/

public class CustomGraphLinkedList {
	boolean directed;
    CustomVertex[] adjLists;
	String file;
     
    public CustomGraphLinkedList(String file) throws FileNotFoundException {
    	this.file = file;
    	readGraphInputFile();
    }
     
	private void readGraphInputFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));

		String graphType = sc.next();
		boolean undirected = true;
		if (graphType.equals("directed")) {
			undirected = false;
		}

		adjLists = new CustomVertex[sc.nextInt()];

		/* read vertices. */
		for (int v = 0; v < adjLists.length; v++) {
			adjLists[v] = new CustomVertex(sc.next(), null,v);
		}

		/* read edges. */
		while (sc.hasNext()) {

			// read vertex names and translate to vertex numbers
			int vertex1 = indexForName(sc.next());
			int vertex2 = -1;
			if (sc.hasNext()) {
				vertex2 = indexForName(sc.next());
			}
			int weight = 0;
			if (sc.hasNextInt()) {
				weight = sc.nextInt();
			}
			/*
			 * Because order doesn't matter, we are addding to the front of the
			 * list. This saves us traversing through linkedList. add v2 to
			 * front of v1's adjacency list and add v1 to front of v2's
			 * adjacency list
			 */
			if (vertex2 != -1) {
				adjLists[vertex1].neighbor = new Neighbor(vertex2, adjLists[vertex1].getNeighbor(), weight);
			}
			if (undirected && vertex2!=-1) {
				adjLists[vertex2].neighbor = new Neighbor(vertex1, adjLists[vertex2].getNeighbor(), weight);
			}
		}
		if (sc != null) {
			sc.close();
		}

	}

	private int indexForName(String name) {
		for (int v = 0; v < adjLists.length; v++) {
			if (adjLists[v].getName().equals(name)) {
				return v;
			}
		}
		return -1;
	}
     
	/**
	 * Print the graph.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\n");
		for (int v = 0; v < adjLists.length; v++) {
			s.append("|");
			s.append(adjLists[v].getName());
			Neighbor nbr = adjLists[v].getNeighbor();
			s.append("|");
			s.append("vtx:" + adjLists[v].getVertexNum());
			while (nbr != null) {
				s.append(" --> " + adjLists[nbr.getVertexnum()].getName() + "[(wt:" + nbr.getWeight() + "), vtx:"
						+ adjLists[nbr.getVertexnum()].getVertexNum() + "]");
				nbr = nbr.next;
			}
			s.append("\n");
		}
		return s.toString();
	}
     
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) 
    throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        CustomGraphLinkedList graph = new CustomGraphLinkedList(file);
        System.out.println(graph);
        graph.dfs();
        sc.close();
    }

	private void dfs() {
		Stack<CustomVertex> s = new Stack<CustomVertex>();
		s.push(adjLists[0]);
		while (!s.isEmpty()) {
			CustomVertex v = s.pop();
			if (!v.getIsVisited()) {
				System.out.println(v.name);
				v.setIsVisited(true);

			}
			for (Neighbor nbr = v.neighbor; nbr != null; nbr = nbr.next) {
				if (!(adjLists[nbr.vertexNum]).getIsVisited()) {
					s.push(adjLists[nbr.vertexNum]);
				}
			}
		}
	}
 
}