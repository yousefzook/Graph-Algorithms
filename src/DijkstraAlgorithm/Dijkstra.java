package DijkstraAlgorithm;

import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	private List<Edge> edges;
	private Vertex startVertex;
	private PriorityQueue<Vertex> queue;
	private String secondOutputLine;

	private Dijkstra() {
	}

	public Dijkstra(List edges, Vertex startVertex) {
		this.edges = edges;
		this.startVertex = startVertex;
		this.startVertex.setMinDistance(0);
		queue = new PriorityQueue<>();
		secondOutputLine = "";
	}

	public void doAlgorithm() {
		queue.add(startVertex);
		Vertex currentVertex = startVertex;
		while (!queue.isEmpty()) {
			currentVertex = queue.poll();
			relaxNeighbours(currentVertex);
			currentVertex.setVisited(true);
			secondOutputLine += (currentVertex.getName() + " ");
		}
	}

	private void relaxNeighbours(Vertex currentVertex) {
		for (Edge e : currentVertex.getAdjacencies()) {
			Vertex neighbourVertex = e.getTargetVertex();
			if (!neighbourVertex.isVisited()) {
				int neightbourDistance = currentVertex.getMinDistance()
						+ e.getWeight();
				if (neighbourVertex.getMinDistance() > neightbourDistance)
					neighbourVertex.setMinDistance(neightbourDistance);
				if (!queue.contains(neighbourVertex))
					queue.add(neighbourVertex);
			}
		}
	}

	public String getSecondOutputLine() {
		return secondOutputLine;
	}
}
