// data : 2202-10-06
// link : https://www.acmicpc.net/source/50148823
/*
  DFS 재귀호출을 응용한 소수찾기
   - DFS 많이 풀어야할듯
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);

		System.out.println(sb);
	}

	static void DFS(int num, int vector) {
		if (vector == N) {
			if (isPrime(num)) {
				sb.append(num).append('\n');
			}
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			if (isPrime(num * 10 + i)) {
				DFS(num * 10 + i, vector + 1);
			}
		}
	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
