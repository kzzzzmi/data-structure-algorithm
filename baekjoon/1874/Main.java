// data : 2202-08-11
// link : https://www.acmicpc.net/source/47555111
/*
  stack 자료구조를 활용한 문제 해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<Integer>();

		int index = 1;
		while (n > 0) {
			int num = Integer.parseInt(br.readLine());

			for (; index <= num; index++) {
				stack.add(index);
				sb.append('+').append('\n');
			}

			if (num == stack.pop()) {
				sb.append('-').append('\n');
			} else {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			n--;
		}
		System.out.println(sb);
	}

}
