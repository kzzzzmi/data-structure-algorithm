// data : 2202-09-11
// link : https://www.acmicpc.net/source/49011296
/*
   Bubble Sort 활용
   정렬 전의 index와 정렬 후의 index를 이용하여 문제를 해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] A = new int[N][2];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			A[i][0] = Integer.parseInt(br.readLine());
			A[i][1] = i;
		}
		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int[] num1, int[] num2) {
				return num1[0] - num2[0];
			}

		});

		for (int i = 0; i < N; i++) {
			if (A[i][1] - i > answer) {
				answer = A[i][1] - i;
			}
		}

		System.out.println(answer + 1);
	}
}
