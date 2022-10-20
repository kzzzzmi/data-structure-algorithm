// data : 2202-10-21
// link : https://www.acmicpc.net/source/50784689
/*
  그리디 알고리즘 : 현재 상태에서의 최적의 해가 전체 선택지에서 최적의 선택이라고 보는 것
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int count = 0;
		int index = 0;

		for (int i = N - 1; i >= 0; i--) {
			A[i] = Integer.parseInt(br.readLine());
		}

		while (index < N) {
			while (K - A[index] >= 0) {
				K -= A[index];
				count++;
			}
			index++;
		}

		System.out.println(count);
	}

}
