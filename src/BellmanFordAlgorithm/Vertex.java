package BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	private long minDistance;
	private List<Edge> adjacencies;
	private boolean visited;
	private String name;

	public Vertex(String name) {
		minDistance = Integer.MAX_VALUE;
		adjacencies = new ArrayList<>();
		visited = false;
		this.name = name;
	}

	public long getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(long minDistance) {
		this.minDistance = minDistance;
	}

	public List<Edge> getAdjacencies() {
		return adjacencies;
	}

	public void addAdjacent(Edge edge) {
		this.adjacencies.add(edge);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		// TODO Auto-generated method stub
		return Long.compare(this.minDistance, otherVertex.minDistance);
	}

}
