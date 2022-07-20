import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int dep = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			graph.get(dep).add(des);
			graph.get(des).add(dep);
		}
		
		for(int i = 1; i <= N; i++) {
			graph.get(i).sort(null);
		}

		DFS(graph, N, V);
		BFS(graph, N, V);
			
		System.out.println(sb);
	}

	static void BFS(HashMap<Integer, ArrayList<Integer>> graph, int N, int V) {
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer> needVisit = new ArrayList<Integer>();
		needVisit.add(V);
		
		while(needVisit.size() > 0) {
			int temp = needVisit.remove(0);
			if(!visited[temp]) {
				visited[temp] = true;
				sb.append(temp).append(' ');
				needVisit.addAll(graph.get(temp));
			}
		}
		sb.append('\n');
	}

	static void DFS(HashMap<Integer, ArrayList<Integer>> graph, int N, int V) {
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer> needVisit = new ArrayList<Integer>();
		needVisit.add(V);
		
		while(needVisit.size() > 0) {
			int temp = needVisit.remove(needVisit.size() - 1);
			if(!visited[temp]) {
				visited[temp] = true;
				sb.append(temp).append(' ');
				ArrayList<Integer> tempArr = graph.get(temp);
				int index = tempArr.size() - 1;
				while(index >= 0) {
					needVisit.add(tempArr.get(index--));
				}
			}
		}
		sb.append('\n');
	}
}
