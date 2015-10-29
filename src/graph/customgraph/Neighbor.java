package graph.customgraph;

public class Neighbor {
    int vertexNum;
    Neighbor next;
    double weight;
    
	public Neighbor(int vnum, Neighbor nbr) {
		this(vnum, nbr, 0);
	}
    
	public Neighbor(int vnum, Neighbor nbr, double weight) {
		this.vertexNum = vnum;
		next = nbr;
		this.weight = weight;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public int getVertexnum(){
		return vertexNum;
	}
	
	public Neighbor getNext(){
		return next;
	}
}
 