package PrimeAlgorithm;

public class Edge implements Comparable<Edge> {

	private Vertex startVertex;
	private Vertex targetVertex;
	private int weight;

	private Edge() {
	}

	public Edge(Vertex startVertex, Vertex targetVertex, int weight) {
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
		this.weight = weight;
	}

	public int getWeight() {
		return this.weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}
	
	public Vertex getTargetVertex() {
		return targetVertex;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.getWeight());
	}

}
