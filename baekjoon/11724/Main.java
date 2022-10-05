// data : 2202-10-05
// link : https://www.acmicpc.net/source/50136887
/*
  DFS를 이용한 그래프 연결 요소의 개수 구하기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		Stack<Integer> needVisit = new Stack<Integer>();
		ArrayList<Integer> adjacentList = new ArrayList<Integer>();
		boolean[] checkVisit = new boolean[N + 1];
		int u, v, node;
		int index = 1;
		int count = 0;

		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		while (index <= N) {
			if (!checkVisit[index]) {
				checkVisit[index] = true;
				needVisit.push(index);
				while (!needVisit.isEmpty()) {
					node = needVisit.pop();
					adjacentList = graph.get(node);
					for (int adjacent : adjacentList) {
						if (!checkVisit[adjacent]) {
							checkVisit[adjacent] = true;
							needVisit.push(adjacent);
						}
					}
				}
				count++;
			}
			index++;
		}

		System.out.println(count);

	}
}
