package graph.customgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CustomGraphHelperMethods {
		
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
}
