package graph.customgraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/**
 * This uses a custom link list kind of structure. More of class Node{ } kind.
 * Use this class for weighted graph. This is very similar to the one in generic
 * package but is more customized to suit weighted graph.
 * 
 * Note: The graph is assumed to be connected
 * 
 * @author sridhar
 * 
 */
  
/*- Adjacency list Representation.
* Custom Array [] - > Custom LinkedList.
*  ----         __________       ______________
*  ! A  ! ->   !_B_!__!___! -> !_C_!__!_NULL_!
*  ----
*
*/

public class CustomGraphLinkedList {
	private boolean undirected = true;
	private CustomVertex[] adjLists;
	private String file;
	private static String DIRECTED = "directed";

	public CustomGraphLinkedList(String file) throws FileNotFoundException {
		this.file = file;
		readGraphInputFile();
	}

	private void readGraphInputFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
		String graphType = sc.next();
		if (graphType.equals(DIRECTED)) {
			undirected = false;
		}
		adjLists = new CustomVertex[sc.nextInt()];
		/* read vertices. */
		for (int v = 0; v < adjLists.length; v++) {
			adjLists[v] = new CustomVertex(sc.next(), null, v);
		}
		readEdges(sc);
		if (sc != null) {
			sc.close();
		}
	}

	/**
	 * Read edges from the Adjacency List.
	 * 
	 * Because the order doesn't matter, we add it to the front of the list.
	 * This saves us traversing through linkedList. add v2 to front of v1's
	 * adjacency list and add v1 to front of v2's adjacency list
	 * 
	 * @param sc
	 */
	private void readEdges(Scanner sc) {
		while (sc.hasNext()) {
			int vertex1 = CustomGraphHelperMethods.indexForName(sc.next(),adjLists);
			int vertex2 = -1;
			if (sc.hasNext()) {
				vertex2 = CustomGraphHelperMethods.indexForName(sc.next(),adjLists);
			}
			double weight = 0;
			Pattern p = Pattern.compile("wt:((\\d+(\\.)*\\d*))");
			if (sc.hasNext(p)) {
				String next = sc.next(p);
				Matcher weightPtn = p.matcher(next);
				if (weightPtn.find()) {
					weight = Double.parseDouble(weightPtn.group(1));
				}
			}
			if (vertex2 != -1) {
				adjLists[vertex1].addNeighbor(new Neighbor(vertex2, adjLists[vertex1].getNeighbor(), weight));
			}
			if (undirected && vertex2 != -1) {
				adjLists[vertex2].addNeighbor(new Neighbor(vertex1, adjLists[vertex2].getNeighbor(), weight));
			}
		}
	}

	/**
	 * Print the graph.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		CustomVertex[] adjLists = getAdjacenyList();
		s.append("Adjacency List of the Graph: \n\n");
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
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter graph input file name: ");
		String file = sc.nextLine();
		CustomGraphLinkedList graph = new CustomGraphLinkedList(file);
		System.out.println(graph);
		System.out.println("Topological Sort via DFS \n");
		CustomGraphHelperMethods.topologicalSortDfs(graph.adjLists[0], graph.getAdjacenyList());
		CustomGraphHelperMethods.printTopoSortDFS();
		graph.resetVisitedFlag();
		System.out.println("Topological Sort via Array \n");
		CustomGraphHelperMethods.topologicalSortArray(graph.getAdjacenyList());
		graph.resetVisitedFlag();
		System.out.println("\n DFS Recursive \n");
		CustomGraphHelperMethods.recursiveDfs(graph.adjLists[0], graph.getAdjacenyList());
		System.out.println("\n BFS \n");
		graph.resetVisitedFlag();
		CustomGraphHelperMethods.bfs(graph.getAdjacenyList());
		System.out.println(" \n DFS stack \n");
		graph.resetVisitedFlag();
		CustomGraphHelperMethods.dfs(graph.getAdjacenyList());
		graph.resetVisitedFlag();
		System.out.println(" \n Prim's Algo \n");
		graph.resetVisitedFlag();
		CustomGraphHelperMethods.PrimsAlgo(graph.getAdjacenyList());
		sc.close();
	}

	/**
	 * TODO: Need to find a better solution.
	 */
	private void resetVisitedFlag() {
		for (CustomVertex v : adjLists) {
			v.setIsVisited(false);
		}
	}

	/**
	 * Getter for Adjacency list.
	 * 
	 * @return Adjacency List.
	 */
	public CustomVertex[] getAdjacenyList() {
		return adjLists;
	}
}