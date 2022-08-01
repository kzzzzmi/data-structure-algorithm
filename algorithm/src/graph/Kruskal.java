package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Edge implements Comparable<Edge> {

	int weight;
	String node1;
	String node2;

	public Edge(int weight, String node1, String node2) {
		this.weight = weight;
		this.node1 = node1;
		this.node2 = node2;
	}

	@Override
	public String toString() {
		return "(" + weight + ", " + node1 + ", " + node2 + ")";
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Kruskal {

	HashMap<String, String> parent = new HashMap<>();
	HashMap<String, Integer> rank = new HashMap<String, Integer>();

	public static void main(String[] args) {
		ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(7, "A", "B"));
		edges.add(new Edge(5, "A", "D"));
		edges.add(new Edge(7, "B", "A"));
		edges.add(new Edge(8, "B", "C"));
		edges.add(new Edge(9, "B", "D"));
		edges.add(new Edge(7, "B", "E"));
		edges.add(new Edge(8, "C", "B"));
		edges.add(new Edge(5, "C", "E"));
		edges.add(new Edge(5, "D", "A"));
		edges.add(new Edge(9, "D", "B"));
		edges.add(new Edge(7, "D", "E"));
		edges.add(new Edge(6, "D", "F"));
		edges.add(new Edge(7, "E", "B"));
		edges.add(new Edge(5, "E", "C"));
		edges.add(new Edge(7, "E", "D"));
		edges.add(new Edge(8, "E", "F"));
		edges.add(new Edge(9, "E", "G"));
		edges.add(new Edge(6, "F", "D"));
		edges.add(new Edge(8, "F", "E"));
		edges.add(new Edge(11, "F", "G"));
		edges.add(new Edge(9, "G", "E"));
		edges.add(new Edge(11, "G", "F"));
		
		Kruskal kruskal = new Kruskal();
		System.out.println(kruskal.kruskal(vertices, edges));
	}

	public ArrayList<Edge> kruskal(ArrayList<String> vertices, ArrayList<Edge> edges) {
		ArrayList<Edge> mst = new ArrayList<Edge>();
		Edge currEdge;

		// 각 정점을 독립적으로 분리하는 초기화 과정
		initSet(vertices);

		// edges 오름차순 정렬
		Collections.sort(edges);

		// 모든 edge 순회하며 union
		for (int i = 0; i < edges.size(); i++) {
			currEdge = edges.get(i);
			if (union(currEdge.node1, currEdge.node2)) {
				mst.add(currEdge);
			}
		}
		return mst;
	}

	public boolean union(String node1, String node2) {
		String root1 = findRoot(node1);
		String root2 = findRoot(node2);

		if (root1 == root2) {
			return false;
		}

		if (rank.get(root1) > rank.get(root2)) {
			parent.put(root2, root1);
		} else {
			parent.put(root1, root2);
			if (rank.get(root1) == rank.get(root2)) {
				rank.put(root2, rank.get(root2) + 1);
			}
		}
		return true;
	}

	public String findRoot(String vertice) {
		String parentNode = parent.get(vertice);
		if (parentNode != vertice) {
			parent.put(vertice, findRoot(parentNode));
		}
		return parent.get(vertice);
	}

	public void initSet(ArrayList<String> vertices) {
		for (int i = 0; i < vertices.size(); i++) {
			String vertice = vertices.get(i);
			parent.put(vertice, vertice);
			rank.put(vertice, 0);
		}
	}

}
