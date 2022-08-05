package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Dijkstar {
	
	static class Edge implements Comparable<Edge>{
		String vertex;
		int distance;
		
		public Edge(String vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
		
		@Override
		public String toString() {
			return vertex + "까지 가중치" + distance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int vertexNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < vertexNum; i++) {
			graph.put(st.nextToken(), new ArrayList<Edge>());
		}
			
		for(int i = 0; i < edgeNum; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(st.nextToken()).add(new Edge(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
		
		System.out.println(dijkstra(graph, "A"));
	}
	
	public static HashMap<String, Integer> dijkstra(HashMap<String, ArrayList<Edge>> graph, String start) {
		HashMap<String, Integer> distances = new HashMap<String, Integer>();
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
		
		for(String s : graph.keySet()) {
			distances.put(s, Integer.MAX_VALUE);
		}
		distances.put(start, 0);
		priorityQueue.add(new Edge(start, 0));
		
		while(priorityQueue.size() > 0) {
			Edge edge= priorityQueue.poll();
			String currVertex = edge.vertex;
			int currDistance = edge.distance;
			
			if(distances.get(currVertex) < currDistance) {
				continue;
			}
			
			ArrayList<Edge> adjacentEdgeList = graph.get(currVertex);
			for(int i = 0; i < adjacentEdgeList.size(); i++) {
				Edge adjacentEdge = adjacentEdgeList.get(i);
				String adjacentVertex = adjacentEdge.vertex;
				int weight = adjacentEdge.distance;
				int distance = weight + currDistance;
				
				if(distances.get(adjacentVertex) > distance) {
					distances.put(adjacentVertex, distance);
					priorityQueue.add(new Edge(adjacentVertex, distance));
				}
			}
		}
		
		return distances;
	}

}
/*
6 9
A B C D E F
A B 8
A C 1
A D 2
C B 5
C D 2
D E 3
D F 5
E F 1
F A 5
*/
