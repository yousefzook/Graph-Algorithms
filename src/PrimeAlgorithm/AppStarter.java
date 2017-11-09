package PrimeAlgorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import javax.print.attribute.HashPrintJobAttributeSet;

public class AppStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vertex> unvisitedVertices = new ArrayList<Vertex>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n = in.nextInt();
		String name = "";
		Hashtable<String, Vertex> vertices = new Hashtable<>();
		Vertex[] verteciesArr = new Vertex[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the vertex[" + i + "] name:");
			name = in.next();
			Vertex vertex = new Vertex(name);
			vertices.put(name, vertex);
			verteciesArr[i] = vertex;
		}
		System.out.println("Enter number of edges:");
		n = in.nextInt();
		String edge = "";
		for (int i = 0; i < n; i++) {
			System.out.println("Enter edgge[" + i
					+ "] in format vertex,othervertex,intWeight");
			edge = in.next();
			String[] info = edge.split(",");
			Vertex startVertex = vertices.get(info[0]);
			Vertex targetVertex = vertices.get(info[1]);
			int weight = Integer.parseInt(info[2]);
			startVertex
					.addNeighbour(new Edge(startVertex, targetVertex, weight));

		}
		for (int i = 0; i < verteciesArr.length; i++)
			unvisitedVertices.add(verteciesArr[i]);

		Algorithm tester = new Algorithm(unvisitedVertices);
		System.out.println("Enter the start vertex name:");
		name = in.next();
		Vertex startVer = vertices.get(name);
		tester.primsAlgorithm(startVer);
		tester.printSpanningTree();
	}

}
