package PrimeAlgorithm;

import java.util.ArrayList;

public class Vertex {

	private String name;
	private Vertex previousVertex;
	private ArrayList<Edge> adjanciesEdges;

	private Vertex() {
	}

	public Vertex(String name) {
		this.name = name;
		adjanciesEdges = new ArrayList<Edge>();
	}

	public void addNeighbour(Edge edge) {
		adjanciesEdges.add(edge);
		edge.getTargetVertex().makeUndirected(edge);
	}

	public void makeUndirected(Edge edge) {
		Vertex from = edge.getStartVertex();
		Vertex to = edge.getTargetVertex();
		Edge flippedEdge = new Edge(to, from, edge.getWeight());
		adjanciesEdges.add(flippedEdge);
	}

	public String getName() {
		return name;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public ArrayList<Edge> getAdjanciesEdges() {
		return adjanciesEdges;
	}

}
