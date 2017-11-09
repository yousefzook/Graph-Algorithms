package BellmanFordAlgorithm;

import java.util.List;

public class BellmanFord {

	private List<Edge> edges;
	private List<Vertex> vertices;

	private BellmanFord() {
	}

	public BellmanFord(List<Edge> edges, List<Vertex> vertices) {
		this.edges = edges;
		this.vertices = vertices;
	}

	public boolean doAlgorithm() {
		for (int i = 0; i < vertices.size() - 1; i++) {
			for (Edge e : edges) {
				relax(e);
			}
		}
		for (Edge e : edges)
			if (hasCycle(e))
				return false;
		return true;
	}

	private void relax(Edge e) {
		Vertex startVertex = e.getStartVertex();
		Vertex targetVertex = e.getTargetVertex();
		long newDistance = startVertex.getMinDistance() + e.getWeight();
		if (newDistance < targetVertex.getMinDistance())
			targetVertex.setMinDistance(newDistance);
	}

	private boolean hasCycle(Edge e) {
		Vertex startVertex = e.getStartVertex();
		Vertex targetVertex = e.getTargetVertex();
		long newDistance = startVertex.getMinDistance() + e.getWeight();
		return (newDistance < targetVertex.getMinDistance());
	}
}
