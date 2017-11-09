package PrimeAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Algorithm {

	private ArrayList<Edge> spanningTree;
	private ArrayList<Vertex> unvisitedVertices;
	private PriorityQueue<Edge> edgeHeap;
	private int fullWeight;

	private Algorithm() {
	}

	public Algorithm(ArrayList<Vertex> unvisitedVertices) {
		this.unvisitedVertices = unvisitedVertices;
		this.spanningTree = new ArrayList<Edge>();
		this.edgeHeap = new PriorityQueue<Edge>();
	}

	public void primsAlgorithm(Vertex startingVertex) {
		this.unvisitedVertices.remove(startingVertex);
		while (!unvisitedVertices.isEmpty()) {
			for (Edge edge : startingVertex.getAdjanciesEdges()) {
				if (unvisitedVertices.contains(edge.getTargetVertex()))
					edgeHeap.add(edge);
			}
			Edge minEdge = edgeHeap.remove();
			if (unvisitedVertices.contains(minEdge.getTargetVertex())) {
				spanningTree.add(minEdge);
				fullWeight += minEdge.getWeight();
			}
			startingVertex = minEdge.getTargetVertex();
			unvisitedVertices.remove(startingVertex);
		}
	}

	public void printSpanningTree() {
		System.out.println("full weight = " + fullWeight);
		for (Edge edge : spanningTree)
			System.out.println("Edge: from " + edge.getStartVertex().getName()
					+ "  to " + edge.getTargetVertex().getName()
					+ "  || weight:" + edge.getWeight());
	}
}
