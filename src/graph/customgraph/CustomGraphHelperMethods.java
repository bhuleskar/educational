package graph.customgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graph.customgraph.graphalgos.Prims;

public class CustomGraphHelperMethods {
	
	private static Stack stck= new Stack();
		
	public static void bfs(CustomVertex[] adjLists) {
		List<CustomVertex> lst = new ArrayList<CustomVertex>();
		int parent[] = new int[adjLists.length];
		lst.add(adjLists[0]);
		parent[0] = -1;
		while (!lst.isEmpty()) {
			CustomVertex vertex = lst.remove(0);
			if (!vertex.getIsVisited()) {
				System.out.println(vertex.getName());
				vertex.setIsVisited(true);
			}
			for (Neighbor nbr = vertex.neighbor; nbr != null; nbr = nbr.next) {
				if (!(adjLists[nbr.getVertexnum()]).getIsVisited()) {
					parent[nbr.getVertexnum()] = vertex.getVertexNum();
					lst.add(adjLists[nbr.getVertexnum()]);
				}
			}
		}
		
		for(CustomVertex c : adjLists){
			if(!c.getIsVisited()){
				System.out.println(c.getName());
				c.setIsVisited(true);
			}
		}
		int i=0;
		for(int a: parent){
			System.out.println("Parent of " + adjLists[i].getName()  + " =" + a);
			i++;
		}
		//System.out.println("\n Finding cycles in  BFS \n");
		//findCycles(5, 2, parent);
	}

	public static void dfs(CustomVertex[] adjLists) {
		Stack<CustomVertex> s = new Stack<CustomVertex>();
		int parent[] = new int[adjLists.length];
		s.push(adjLists[0]);
		parent[0] = -1;
		while (!s.isEmpty()) {
			CustomVertex v = s.pop();
			if (!v.getIsVisited()) {
				System.out.println(v.name);
				v.setIsVisited(true);
			}
			for (Neighbor nbr = v.neighbor; nbr != null; nbr = nbr.next) {
				if (!(adjLists[nbr.vertexNum]).getIsVisited()) {
					parent[nbr.getVertexnum()] = v.getVertexNum();
					s.push(adjLists[nbr.vertexNum]);
				}
			}
		}
		
		/**
		 * For connected directed graphs, sometime there could be a scenario
		 * wherein the node might not have been discovered by other nodes, in
		 * that case we check if all of the nodes have been discovered and
		 * processed.
		 */
		for(CustomVertex c : adjLists){
			if(!c.getIsVisited()){
				System.out.println(c.getName());
				c.setIsVisited(true);
			}
		}
		
		int i = 0;
		for (int a : parent) {
			System.out.println("DFS Parent of " + adjLists[i].getName() + " =" + a);
			i++;
		}
		// System.out.println("\n Finding cycles in DFS \n");
		// findCycles(5, 2, parent);
	}
	
	public static void recursiveDfs(CustomVertex v, CustomVertex[] adjLists) {
		if (v == null || v.getNeighbor() == null) {
			return;
		}
		System.out.println(v.getName());
		v.setIsVisited(true);
		for (Neighbor nbr = v.neighbor; nbr != null; nbr = nbr.next) {
			if (!adjLists[nbr.getVertexnum()].isVisited) {
				recursiveDfs(adjLists[nbr.getVertexnum()], adjLists);
			}
		}
		
		for(CustomVertex c : adjLists){
			if(!c.getIsVisited()){
				System.out.println(c.getName());
				c.setIsVisited(true);
			}
		}
	}
	
	/**
	 * Topological Sort via DFS.
	 * @param v
	 * @param adjLists
	 */
	public static void topologicalSortDfs(CustomVertex v, CustomVertex[] adjLists) {
		if (v == null ) {
			return;
		}
		v.setIsVisited(true);
		for (Neighbor nbr = v.neighbor; nbr != null; nbr = nbr.next) {
			if (!adjLists[nbr.getVertexnum()].isVisited) {
				topologicalSortDfs(adjLists[nbr.getVertexnum()], adjLists);
			}
		}
		stck.push(v.getName());
	}
	
	//TODO: Print the missing one comparing with others. Wil be usually one.
	public static void printTopoSortDFS(){
		while (!stck.isEmpty()){
			System.out.println(stck.pop());
		}
	}
	
	
	/**
	 * 
	 * @param adjLists
	 */
	public static void topologicalSortArray(CustomVertex[] adjLists) {
		int[] indegreeArray = new int[adjLists.length];
		Stack<CustomVertex> s = new Stack<CustomVertex>();
		for (int i = 0; i < indegreeArray.length; i++) {
			indegreeArray[i] = 0;
		}

		for (CustomVertex v : adjLists) {
			for (Neighbor nbr = v.neighbor; nbr != null; nbr = nbr.next) {
				indegreeArray[nbr.getVertexnum()]++;
			}
		}

		for (int i = 0; i < indegreeArray.length; i++) {
			CustomVertex v = null;
			if (indegreeArray[i] == 0) {
				v = indexToVertex(i, adjLists);
				s.push(v);
			}
		}

		while (!s.isEmpty()) {
			CustomVertex v = s.pop();
			System.out.println(v.getName());
			for (Neighbor nbr = v.neighbor; nbr != null; nbr = nbr.next) {
				indegreeArray[nbr.getVertexnum()]--;
				if (indegreeArray[nbr.getVertexnum()] == 0) {
					v = indexToVertex(nbr.getVertexnum(), adjLists);
					s.push(v);
				}
			}
		}
	}
	
	/** Find a cycle in a graph.
	 * 
	 * @param child
	 * @param assumedParent
	 * @param parent
	 */
	public static void findCycles(int child, int assumedParent, int[] parent) {
		if (parent[child] != assumedParent) {
			System.out.println(String.format("Cycle from child %s to assumend parent %s", child, assumedParent));
			findPath(assumedParent - 1, child - 1, parent);
		}
	}
	
	/**
	 * Find a path from X to Y. Note: If x is the root, then we get the
	 * shortest path from X i.e root to Y
	 * 
	 * @param start
	 * @param end
	 * @param parents
	 */
	public static void findPath(int start, int end, int parents[]) {
		if ((start == end) || end == -1) {
			System.out.println(start);
		} else {
			findPath(start, parents[end], parents);
			System.out.println(end);
		}
	}
	
	/**
	 * Read vertex names and translate to vertex numbers
	 */
	public static int indexForName(String name, CustomVertex[] adjLists) {
		for (int v = 0; v < adjLists.length; v++) {
			if (adjLists[v].getName().equals(name)) {
				return v;
			}
		}
		return -1;
	}
	
	/**
	 * Read vertex names and translate to vertex numbers
	 */
	public static CustomVertex indexToVertex(int num, CustomVertex[] adjLists) {
		for (int v = 0; v < adjLists.length; v++) {
			if (adjLists[v].getVertexNum() == num) {
				return adjLists[v];
			}
		}
		return null;
	}
	
	public static void PrimsAlgo(CustomVertex[] adjLists){
		Prims prim = new Prims(adjLists);
	}
}
