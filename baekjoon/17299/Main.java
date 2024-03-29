// data : 2202-08-12
// link : https://www.acmicpc.net/source/47616363
/*
  전 문제인 오등수와 비슷한 문제
   - count 라는 배열이 하나 추가된 것 빼곤 같은 로직
   - stack 에 검사해야 하는 index를 넣고 문제해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Stack<Integer> stack = new Stack<Integer>();
		int[] inputs = new int[N];
		int[] count = new int[1000001];
		int[] answer = new int[N];

		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
			count[inputs[i]]++;
		}

		stack.push(0);

		for (int i = 1; i < N; i++) {
			while (!stack.empty() && count[inputs[stack.peek()]] < count[inputs[i]]) {
				answer[stack.pop()] = inputs[i];
			}

			stack.push(i);
		}

		while (!stack.empty()) {
			answer[stack.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(' ');
		}

		System.out.println(sb);
	}

}
