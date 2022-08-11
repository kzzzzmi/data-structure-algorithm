// data : 2202-08-12
// link : https://www.acmicpc.net/source/47584146
/*
  stack을 활용한 문제해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static 	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<Character>();
		int index;
		
		for(index = 0; index < input.length; index++) {
			if(input[index] == '<') {
				pop(stack);
				sb.append(input[index]);
				while(input[++index] != '>') {
					sb.append(input[index]);
				}
				sb.append(input[index]);
			} else {
				if(input[index] == ' ') {
					pop(stack);
					sb.append(' ');
				} else {
					stack.push(input[index]);
				}
			}
		}
		pop(stack);
		
		System.out.println(sb);
	}
	
	public static void pop(Stack<Character> stack) {
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}

}
