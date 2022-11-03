// data : 2202-11-04
// link : https://www.acmicpc.net/source/51300669
/*
  BFS를 활용한 그래프 
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] check;
	static int[] distances;
	static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
	static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		distances = new int[N + 1];
		check = new boolean[N + 1];
		boolean flag = false;

		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}

		BFS(X);

		for (int i = 1; i <= N; i++) {
			if (distances[i] == K) {
				bw.write(i + "\n");
				flag = true;
			}
		}

		bw.flush();
		if (!flag) {
			System.out.println(-1);
		}
	}

	static void BFS(int vertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);

		ArrayList<Integer> edges;
		check[vertex] = true;

		while (!queue.isEmpty()) {
			int v = queue.poll();
			edges = graph.get(v);

			for (int edge : edges) {
				if (!check[edge]) {
					distances[edge] = distances[v] + 1;
					check[edge] = true;
					if (distances[edge] < K) {
						queue.add(edge);
					}
				}
			}
		}
	}

}
