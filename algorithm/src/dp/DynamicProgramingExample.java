package dp;

import java.util.Scanner;

public class DynamicProgramingExample {
	int a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(fibonacciDP(num));
		System.out.println(fibonacciDC(num));
	}
	
	public static int fibonacciDP(int num) {
		int[] arr = new int[num + 1];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[num];
	}
	
	public static int fibonacciDC(int num) {
		if(num <= 1) {
			return num;
		}
		return fibonacciDC(num - 1) + fibonacciDC(num - 2);
	}

}
