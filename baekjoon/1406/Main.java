// data : 2202-08-11
// link : https://www.acmicpc.net/source/47560119
/*
  StringBuilder를 이용해서 문자열 처리했을 때 시간초과 계속뜸...
  문제의 방향성이 안잡혀서 찾아본 결과 Stack 2개를 활용하는 문제인걸 보고 다시 한번 감탄했음,,, :(
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
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		Stack<Character> leftStack = new Stack<Character>();
		Stack<Character> rightStack = new Stack<Character>();
		String input, subInput;
		
		for(int i = 0; i < str.length(); i++) {
			leftStack.add(str.charAt(i));
		}
		
		while(M > 0) {
			st = new StringTokenizer(br.readLine());
			input = st.nextToken();
			
			if(input.equals("L")) {
				if(!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}				
			} else if(input.equals("D")) {
				if(!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop());
				}
			} else if(input.equals("B")) {
				if(!leftStack.isEmpty()) {
					leftStack.pop();
				}
			} else {
				subInput = st.nextToken();
				leftStack.push(subInput.charAt(0));
			}			
			M--;
		}
		
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		while(!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		System.out.println(sb);
	}

}
