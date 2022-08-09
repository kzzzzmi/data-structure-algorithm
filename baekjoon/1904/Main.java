// data : 2202-08-09
// link : https://www.acmicpc.net/source/47447807
/*
  동적 계획법을 활용한 문제 해결
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N + 1];
		num[0] = 1;
		num[1] = 1;
		
		for(int i = 2; i < num.length; i++) {
			num[i] = (num[i-1] + num[i-2]) % 15746;
		}
		System.out.println(num[N]);
	}	
}
