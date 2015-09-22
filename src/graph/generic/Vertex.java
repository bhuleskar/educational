package graph.generic;

import java.util.LinkedList;

public class Vertex{
	String name;
	LinkedList<Vertex> neighborList;
	boolean isVisited;
	int vertexNum;

	Vertex(String name, LinkedList<Vertex> neighbors, int vertexNum) {
		this.name = name;
		this.neighborList = neighbors;
		this.vertexNum = vertexNum;
	}

	public void setIsVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public boolean getIsVisited() {
		return isVisited;
	}
	
	public String vertexName(int vertexNum) {
		if (vertexNum == this.vertexNum) {
			return name;
		}
		return null;
	}
}
