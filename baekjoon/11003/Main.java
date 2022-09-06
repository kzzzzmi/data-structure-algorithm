// data : 2202-09-06
// link : https://www.acmicpc.net/source/48820888
/*
  슬라이딩 윈도우 알고리즘과 덱 자료구조를 활용한 문제해결
  - 생각하기 어려움
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

	static class Node {
		int value;
		int index;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		LinkedList<Node> deque = new LinkedList<Node>();
		int index, num;

		st = new StringTokenizer(br.readLine());

		for (index = 0; index < N; index++) {
			num = Integer.parseInt(st.nextToken());
			if (!deque.isEmpty() && deque.peek().index < index - L + 1) {
				deque.pollFirst();
			}
			while (!deque.isEmpty() && deque.peekLast().value > num) {
				deque.pollLast();
			}
			deque.add(new Node(num, index));
			sb.append(deque.peekFirst().value).append(' ');
		}

		System.out.println(sb);
	}

}
