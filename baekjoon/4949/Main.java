// data : 2202-08-14
// link : https://www.acmicpc.net/source/47704607
/*
  stack을 활용한 유효한 괄호 체크
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack;
		String input;
		boolean valid;

		input = br.readLine();
		while (!input.equals(".")) {
			stack = new Stack<Character>();
			valid = true;

			for (int index = 0; index < input.length(); index++) {
				char temp = input.charAt(index);

				if (temp == '(') {
					stack.push('(');
				} else if (temp == '[') {
					stack.push('[');
				} else if (temp == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						valid = false;
						break;
					}
				} else if (temp == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						valid = false;
						break;
					}
				}
			}
			if (stack.isEmpty() && valid) {
				sb.append("yes").append('\n');
			} else {
				sb.append("no").append('\n');
			}

			input = br.readLine();
		}

		System.out.println(sb);

	}
}
