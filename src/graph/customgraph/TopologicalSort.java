package graph.customgraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TopologicalSort<T> {

	private Deque<Vertex<T>> topoSort(Graph<T> graph) {
		Deque<Vertex<T>> stack = new ArrayDeque<>();
		Set<Vertex<T>> visited = new HashSet<>();
		for (Vertex<T> vertex : graph.getAllVertex()) {
			if (visited.contains(vertex)) {
				continue;
			}
			topSortUtil(vertex, visited, stack);
		}
		return stack;
	}

	private void topSortUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Deque<Vertex<T>> stack) {
		visited.add(vertex);
		for (Vertex<T> child : vertex.getAdjacentVertexes()) {
			if (visited.contains(child)) {
				continue;
			}
			topSortUtil(child, visited, stack);
		}
		stack.offerFirst(vertex);
	}

	public static void main(String[] args) {
		Graph<String> graph = new Graph<>(true);
		graph.addEdge("A", "C");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("C", "E");
		graph.addEdge("E", "F");
		graph.addEdge("D", "F");
		graph.addEdge("F", "G");

		TopologicalSort<String> sort = new TopologicalSort<>();
		Deque<Vertex<String>> result = sort.topoSort(graph);
		while (!result.isEmpty()) {
			System.out.println(result.pop());
		}
	}
}
