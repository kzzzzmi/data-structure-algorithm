// data : 2202-07-24
// link : https://www.acmicpc.net/source/46584786
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
		return "vertex : " + vertex + ", distance :  " + distance;
	}

	@Override
	public int compareTo(Edge o) {
		return this.distance - o.distance;
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, ArrayList<Edge>> graph = new HashMap<Integer, ArrayList<Edge>>();
		for(int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int ver1 = Integer.parseInt(st.nextToken());
			int ver2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.get(ver1).add(new Edge(ver2, weight)); 
			graph.get(ver2).add(new Edge(ver1, weight)); 
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int way1 = 0;
		way1 += dijkstra(graph, 1, v1);
		way1 += dijkstra(graph, v1, v2);
		way1 += dijkstra(graph, v2, N);
		
		int way2 = 0;
		way2 += dijkstra(graph, 1, v2);
		way2 += dijkstra(graph, v2, v1);
		way2 += dijkstra(graph, v1, N);
		
		if(way1 >= 200000000 && way2 >= 200000000) {
			System.out.println(-1);
		} else {
			System.out.println(way1 < way2 ? way1 : way2);
		}	
	}
	
	public static int dijkstra(HashMap<Integer, ArrayList<Edge>> graph, int start, int end) {
		HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
		
		for(int i = 1; i <= graph.size(); i++) {
			distances.put(i, 200000000);
		}
		distances.put(start, 0);
		priorityQueue.add(new Edge(start, 0));
		
		while(priorityQueue.size() > 0) {
			Edge edge = priorityQueue.poll();
			int vertex = edge.vertex;
			int distance = edge.distance;
			
			if(distances.get(vertex) < distance) {
				continue;
			}
			
			ArrayList<Edge> adjacents = graph.get(vertex);
			for(int i = 0; i < adjacents.size(); i++) {
				Edge adjacent = adjacents.get(i);
				int adjacentVertex = adjacent.vertex;
				int weight = adjacent.distance;
				int currDistance = distance + weight;
				
				if(currDistance < distances.get(adjacentVertex)) {
					distances.put(adjacentVertex, currDistance);
					priorityQueue.add(new Edge(adjacentVertex, currDistance));
				}
			}
		}
		return distances.get(end);
	}

}
