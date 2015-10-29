package graph.customgraph.graphalgos;

import graph.customgraph.CustomVertex;
import graph.customgraph.Neighbor;

public class Prims {

	boolean[] intree;
	double distance[];
	CustomVertex[] adjLists;

	public Prims(CustomVertex[] adjLists) {
		this.adjLists = adjLists;
		initIntree();
		initDistance();
		primsAlgo(adjLists[0]);
	}

	public void primsAlgo(CustomVertex v) {
		distance[v.getVertexNum()] = 0;
		double totalCost=0;
		double dist=0;
		while (!intree[v.getVertexNum()]) {
			totalCost+=dist;
			 dist = Integer.MAX_VALUE;
			System.out.println(v.getName());
			intree[v.getVertexNum()] = true;
			for (Neighbor nbr = v.getNeighbor(); nbr != null; nbr = nbr.getNext()) {
				if (distance[nbr.getVertexnum()] > nbr.getWeight()  && !intree[nbr.getVertexnum()]) {
					distance[nbr.getVertexnum()] = nbr.getWeight();
				}
			}

			for (CustomVertex vtx : adjLists) {
				if (dist > distance[vtx.getVertexNum()] && !intree[vtx.getVertexNum()]) {
					dist = distance[vtx.getVertexNum()];
					v = vtx;
				}
			}
		}
		System.out.println("Total cost: " + totalCost);
	}

	private void initDistance() {
		intree = new boolean[adjLists.length];
		for (int i = 0; i < adjLists.length; i++) {
			intree[i] = false;
		}
	}

	private void initIntree() {
		distance = new double[adjLists.length];
		for (int i = 0; i < adjLists.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
	}
}
