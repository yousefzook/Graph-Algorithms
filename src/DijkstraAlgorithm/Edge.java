package DijkstraAlgorithm;

public class Edge {

	private Vertex startVertex;
	private Vertex targetVertex;
	private int weight;

	public Edge(Vertex startVertex, Vertex targetVertex, int weight) {
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
		this.weight = weight;
		this.startVertex.addAdjacent(this);
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex tergetVertex) {
		this.targetVertex = tergetVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
