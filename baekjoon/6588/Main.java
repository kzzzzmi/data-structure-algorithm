// data : 2202-08-13
// link : https://www.acmicpc.net/source/47668126
/*
  에라토스테네스의 체 소수구하는 알고리즘 사용
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean[] isPrime = new boolean[1000001];
	static int[] primes = new int[78498];
	static int index = 0;
	
	public static void main(String[] args) throws IOException {

		primeCheck();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		
		while(num != 0) {
			for(int i : primes) {
				if(isPrime[num - i]) {
					sb.append(num + " = " + i + " + " + (num - i)).append('\n');
					break;
				} else if(i > num) {
					sb.append("Goldbach's conjecture is wrong.").append('\n');
				}
			}
			
			num = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}
	
	public static void primeCheck() {
		int primeSize = isPrime.length;
		
		for(int i = 2; i < primeSize; i++) {
			isPrime[i] = true;
		}
		
		for(int i = 2; i < primeSize; i++) {
			if(isPrime[i]) {
				primes[index++] = i;
				for(int j = i * 2; j < primeSize; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}

}
