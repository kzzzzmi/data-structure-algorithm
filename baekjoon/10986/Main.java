// data : 2202-09-01
// link : https://www.acmicpc.net/source/48571391
/*
  누적합을 이용하는 문제
  10트 넘게함 하하하
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] sumArr = new int[N + 1];
		long[] remainder = new long[M];
		long count = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sumArr[i] = (sumArr[i - 1] + Integer.parseInt(st.nextToken())) % M;
			remainder[sumArr[i]]++;
		}

		count += remainder[0];

		for(int i = 0; i < M; i++) {
			if(remainder[i] > 1) {
				count += remainder[i] * (remainder[i] - 1) / 2;
			}
		}

		System.out.println(count);
	}

}
