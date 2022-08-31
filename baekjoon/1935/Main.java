// data : 2202-08-15
// link : https://www.acmicpc.net/source/47758720
/*
  stack을 활용한 문제해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Double> stack = new Stack<Double>();
		String expression = br.readLine();
		HashMap<Character, Integer> num = new HashMap<Character, Integer>();
		double num1, num2;

		for(int i = 0; i < N; i++) {
			num.put((char)(i + 65), Integer.parseInt(br.readLine()));
		}
		
		for(int i = 0; i < expression.length(); i++) {
			char temp = expression.charAt(i);
			
			if(temp == '*') {
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num1 * num2);
			} else if(temp == '/') {
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num2 / num1);
			} else if(temp == '+') {
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num1 + num2);
			} else if(temp == '-') {
				num1 = stack.pop();
				num2 = stack.pop();
				stack.push(num2 - num1);
			} else {
				stack.push((double)num.get(temp));
			}
		}

		System.out.printf("%.2f", stack.pop());
	}
}
