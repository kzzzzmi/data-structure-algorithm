// data : 2202-08-02
// link : https://www.acmicpc.net/source/47059395
/*
  크루스칼 알고리즘을 통해 최소 
  가중치가 따로 주어지지 않아서 모두 같은 가중치라고 생각하고
  가중치를 기준으로 따로 정렬하지 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


class Edge {
	int node1;
	int node2;
	
	public Edge(int node1, int node2) {
		this.node1 = node1;
		this.node2 = node2;
	}
}

public class Main {

	static HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> rank = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
			
		while(T > 0) {
			ArrayList<Integer> vertices = new ArrayList<Integer>();
			ArrayList<Edge> edges = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int verticeLength = Integer.parseInt(st.nextToken());
			int edgeLength = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i <= verticeLength; i++) {
				vertices.add(i);
			}
			for(int i = 0; i < edgeLength; i++) {
				st = new StringTokenizer(br.readLine());
				edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			sb.append(kruskalAlg(vertices, edges)).append('\n');
			parent.clear();
			rank.clear();
			
			T--;
		}
		System.out.println(sb);
	}
	
	public static int kruskalAlg(ArrayList<Integer> vertices, ArrayList<Edge> edges) {
		ArrayList<Edge> mst = new ArrayList<Edge>();
		Edge currEdge;
		
		// parent rank 초기화
		initSet(vertices);
		
		for(int i = 0; i < edges.size(); i++) {
			currEdge = edges.get(i);
			if(union(currEdge)) {
				mst.add(currEdge);
			}
		}
		return mst.size();
	}
	
	public static boolean union(Edge edge) {
		int root1 = findRoot(edge.node1);
		int root2 = findRoot(edge.node2);
		
		if(root1 == root2) {
			return false;
		}
		
		if(rank.get(root1) > rank.get(root2)) {
			parent.put(root2, root1);
		} else {
			parent.put(root1, root2);
			if(rank.get(root1) == rank.get(root2)) {
				rank.put(root2, rank.get(root2) + 1);
			}
		}
		return true;
	}
	
	public static int findRoot(int node) {
		if(parent.get(node) != node) {
			parent.put(node, findRoot(parent.get(node)));
		}
		return parent.get(node);
	}
	
	public static void initSet(ArrayList<Integer> vertices) {
		for(int i = 0; i < vertices.size(); i++) {
			int vertice = vertices.get(i);
			parent.put(vertice, vertice);
			rank.put(vertice, 0);
		}
	}
}
