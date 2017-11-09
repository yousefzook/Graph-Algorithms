package BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFromFile readFile = new ReadFromFile();
		int[][] graph = readFile.readFile();
		int verticesNumber = readFile.getVerticesNumber();
		List<Vertex> vertices = new ArrayList<>();
		for (int i = 0; i < verticesNumber; i++)
			vertices.add(new Vertex(Integer.toString(i)));
		List<Edge> edges = new ArrayList();
		for (int i = 0; i < graph.length; i++)
			edges.add(new Edge(vertices.get(graph[i][0]),
					vertices.get(graph[i][1]), graph[i][2]));
		vertices.get(0).setMinDistance(0);
		BellmanFord algorithm = new BellmanFord(edges, vertices);
		boolean result = algorithm.doAlgorithm();
		String minDistances = "";
		for (Vertex v : vertices)
			minDistances += v.getMinDistance() + " ";
		System.out.println(result);
		System.out.println(minDistances);
		WriteToFile writeFile = new WriteToFile();
		writeFile.writeToFile(Boolean.toString(result), minDistances);
	}

}
