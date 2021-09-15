package algorithmSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		while(!(a == 0 || b == 0 || c == 0)) {	
			int max = Math.max(Math.max(a, b), c);
			boolean temp = false;
			
			if(max == a) {
				temp = isTriangle(a, b, c);
			} else if(max == b) {
				temp = isTriangle(b, a, c);
			} else {
				temp = isTriangle(c, b, a);
			}
			System.out.println(temp ? "right" : "wrong");
			
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		} 
		
	}
	
	public static boolean isTriangle(int max, int n1, int n2) {
		if(Math.pow(max, 2) == Math.pow(n1, 2) + Math.pow(n2, 2)) {
			return true;
		} 
		return false;
	}
}
