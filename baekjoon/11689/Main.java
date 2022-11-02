// data : 2202-11-02
// link : https://www.acmicpc.net/source/51253262
/*
  1 ~ N 까지의 수 중 N 과 서로소인 수의 개수를 구하는 오일러 파이 개념
  o(N) = 1 ~ N 중 N 과 서로소인 개수
*/

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long ans = N;

		for (long i = 2; i * i <= N; i++) {
			if (N % i == 0) {
				ans = ans - ans / i;
				while (N % i == 0) {
					N /= i;
				}
			}
		}

		if (N > 1) {
			ans = ans - ans / N;
		}

		System.out.println(ans);
	}

}
