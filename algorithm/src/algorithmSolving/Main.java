package algorithmSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num; i++) {
			String str = br.readLine();
			if(isVPS(str)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}	
	}
	
	public static boolean isVPS(String str) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] ch = str.toCharArray();
		for(int i = 0; i < ch.length; i++) {
			if(stack.isEmpty() && ch[i] == ')') {
				return false;
			} else {
				if(ch[i] == '(') {
					stack.push(0);
				} else {
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
