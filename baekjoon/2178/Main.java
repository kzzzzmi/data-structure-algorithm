// data : 2202-10-13
// link : https://www.acmicpc.net/source/50417098
/*
  BFS를 활용한 미로 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int qx[] = { 0, 0, 1, -1 };
	static int qy[] = { 1, -1, 0, 0 };

	static class Node {
		int x;
		int y;
		int count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}

		System.out.println(BFS(map));
	}

	public static int BFS(int[][] map) {
		LinkedList<Node> needVisit = new LinkedList<>();
		needVisit.add(new Node(0, 0, 1));

		while (!needVisit.isEmpty()) {
			Node node = needVisit.poll();
			int x = node.x;
			int y = node.y;
			int count = node.count;

			if (x == N - 1 && y == M - 1) {
				return count;
			}

			map[x][y] = 0;

			for (int i = 0; i < 4; i++) {
				int nextX = x + qx[i];
				int nextY = y + qy[i];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					continue;
				}
				if (map[nextX][nextY] == 1) {
					needVisit.add(new Node(nextX, nextY, count + 1));
					map[nextX][nextY] = 0;
				}
			}
		}

		return 0;
	}

}
