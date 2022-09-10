// data : 2202-09-03
// link : https://www.acmicpc.net/source/48671159
/*
  투 포인터를 활용한 문제해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		int startIndex, endIndex, num, sum;
		int count = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			startIndex = 0;
			endIndex = N - 1;
			num = arr[i];

			while (startIndex < endIndex) {
				if (startIndex == i) {
					startIndex++;
					continue;
				}
				if (endIndex == i) {
					endIndex--;
					continue;
				}

				sum = arr[startIndex] + arr[endIndex];

				if (sum == num) {
					count++;
					break;
				} else if (sum < num) {
					startIndex++;
				} else if (sum > num) {
					endIndex--;
				}
			}
		}

		System.out.println(count);
	}

}
