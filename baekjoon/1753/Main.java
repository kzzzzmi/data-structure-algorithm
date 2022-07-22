// data : 2202-07-22
// link : https://www.acmicpc.net/source/46491178
/*
  Dijkstra 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int vertex;
	int distance;

	public Edge(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "vertex : " + this.vertex + ", distance : " + this.distance;
	}

	@Override
	public int compareTo(Edge o) {
		return this.distance - o.distance;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, ArrayList<Edge>> graph = new HashMap<Integer, ArrayList<Edge>>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vNum = Integer.parseInt(st.nextToken());
		int eNum = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		for (int i = 1; i <= vNum; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int i = 0; i < eNum; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
					.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		dijkstra(graph, start);
	}

	public static void dijkstra(HashMap<Integer, ArrayList<Edge>> graph, int start) {
		int[] distances = new int[graph.size() + 1];
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
		priorityQueue.add(new Edge(start, 0));

		for (int i = 1; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[start] = 0;

		while (priorityQueue.size() > 0) {
			Edge edgeNode = priorityQueue.poll();
			int edgeVertex = edgeNode.vertex;
			int edgeDistance = edgeNode.distance;

			if (distances[edgeVertex] < edgeDistance) {
				continue;
			}

			ArrayList<Edge> adjacentList = graph.get(edgeVertex);
			for (int i = 0; i < adjacentList.size(); i++) {
				Edge adjacentEdge = adjacentList.get(i);
				int adjacentVertex = adjacentEdge.vertex;
				int weight = adjacentEdge.distance;
				int distance = weight + edgeDistance;

				if (distances[adjacentVertex] > distance) {
					distances[adjacentVertex] = distance;
					priorityQueue.add(new Edge(adjacentVertex, distance));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < distances.length; i++) {
			int temp = distances[i];
			if (temp == Integer.MAX_VALUE) {
				sb.append("INF").append('\n');
			} else {
				sb.append(distances[i]).append('\n');
			}
		}
		System.out.println(sb);
	}

}
