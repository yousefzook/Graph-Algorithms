package DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFromFile readFile = new ReadFromFile();
		int[][] graph = readFile.readFile();
		int verticesNumber = readFile.getVerticesNumber();
		Vertex[] vertex = new Vertex[verticesNumber];
		for (int i = 0; i < verticesNumber; i++)
			vertex[i] = new Vertex(Integer.toString(i));
		List<Edge> edges = new ArrayList();
		for (int i = 0; i < graph.length; i++)
			edges.add(new Edge(vertex[graph[i][0]], vertex[graph[i][1]],
					graph[i][2]));
		Dijkstra algorithm = new Dijkstra(edges, vertex[0]);
		algorithm.doAlgorithm();
		String outPutLine1 = "";
		String outPutLine2 = "";
		WriteToFile writeFile = new WriteToFile();
		for (Vertex v : vertex) {
			outPutLine1 += (v.getMinDistance() + " ");
		}
		System.out.println(outPutLine1);
		outPutLine2 = algorithm.getSecondOutputLine();
		System.out.println(outPutLine2);
		writeFile.writeToFile(outPutLine1, outPutLine2);
	}

}
