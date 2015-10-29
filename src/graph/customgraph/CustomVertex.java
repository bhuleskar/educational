package graph.customgraph;

public class CustomVertex {
	String name;
	Neighbor neighbor;
	boolean isVisited;
	int vertexNum;

	CustomVertex(String name, Neighbor neighbors, int vertexNum) {
		this.name = name;
		this.neighbor = neighbors;
		this.vertexNum = vertexNum;
	}
	
	public void addNeighbor(Neighbor neighbor){
		this.neighbor = neighbor;
	}

	public void setIsVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public boolean getIsVisited() {
		return isVisited;
	}
	
	public String getName() {
		return name;
	}
	
	public Neighbor getNeighbor() {
		return neighbor;
	}
	
	public int getVertexNum() {
		return vertexNum;
	}
	
	public int getOutDegree(Neighbor n) {
		int size = 0;
		Neighbor cur = n;
		while (cur != null) {
			cur = cur.next;
			size++;
		}
		return size;
	}
}
