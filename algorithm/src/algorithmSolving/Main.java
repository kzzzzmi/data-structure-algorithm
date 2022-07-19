package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int funcCount = 1;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] fibonacci = new int[41];
		fibonacci[1] = 1;
		fibonacci[2] = 1;
		
		int fibCount = 0;
		for(int i = 3; i <= num; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
			fibCount++;
		}
		fibonacci(num);
		
		System.out.println(funcCount + " " + fibCount);
	}
	
	public static int fibonacci(int num) {
		if(num <= 2) {
			return 1;
		}
		funcCount++;
		return fibonacci(num - 1) + fibonacci(num - 2);
	}
}