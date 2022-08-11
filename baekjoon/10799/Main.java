// data : 2202-08-12
// link : https://www.acmicpc.net/source/47584836
/*
  stack을 활용한 문제해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<Character>();
		int num = 0;
		int panCount = 0;
		int index;
		
		for(index = 0; index < input.length - 1; index++) {
			if(input[index] == '(') {
				if(input[index + 1] == ')') {
					int size = stack.size();
					if(panCount < size) {
						num += size + size - panCount;
						panCount = size;
					} else {
						num += size;
					}
					index++;
				} else {
					stack.push('(');
				}
			} else {
				stack.pop();
				panCount = stack.size();
			}
		}
		
		System.out.println(num);
	}

}
