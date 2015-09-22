package graph.generic;

class Edge implements Comparable<Edge> {
	int vertex1;
	int vertex2;
	double weight;

	Edge(int vertex1, int vertex2, double weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	
	Edge(int vertex1, int vertex2) {
		this(vertex1, vertex2, 0);
	}

	/**
	 * Returns the weight of this edge.
	 *
	 * @return the weight of this edge
	 */
	public double weight() {
		return weight;
	}

	/**
	 * Returns either endpoint of this edge.
	 *
	 * @return either endpoint of this edge
	 */
	public int either() {
		return vertex1;
	}

	/**
	 * Returns the endpoint of this edge that is different from the given
	 * vertex.
	 *
	 * @param vertex
	 *            one endpoint of this edge
	 * @return the other endpoint of this edge
	 * @throws IllegalArgumentException
	 *             if the vertex is not one of the endpoints of this edge
	 */
	public int other(int vertex) {
		if (vertex == vertex1)
			return vertex2;
		else if (vertex == vertex2)
			return vertex1;
		else
			throw new IllegalArgumentException("Illegal endpoint");
	}
	
	public String edgeName(){
		String v = Integer.toString(vertex1) + Integer.toString(vertex2);
		return v;
	}

	/**
	 * Compares two edges by weight. Note that <tt>compareTo()</tt> is not
	 * consistent with <tt>equals()</tt>, which uses the reference equality
	 * implementation inherited from <tt>Object</tt>.
	 *
	 * @param that
	 *            the other edge
	 * @return a negative integer, zero, or positive integer depending on
	 *         whether the weight of this is less than, equal to, or greater
	 *         than the argument edge
	 */
	@Override
	public int compareTo(Edge that) {
		if (this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight())
			return +1;
		else
			return 0;
	}

	/**
	 * Returns a string representation of this edge.
	 *
	 * @return a string representation of this edge
	 */
	public String toString() {
		return String.format("%d-%d %.5f", vertex1, vertex2, weight);
	}

}