// data : 2202-09-03
// link : https://www.acmicpc.net/source/48672919
/*
  슬라이딩 윈도우 알고리즘 활용
  - 범위를 지정하고 범위를 유지한 채 이동하며 
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] input = br.readLine().toCharArray();
		int[] conditions = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			conditions[i] = Integer.parseInt(st.nextToken());
		}

		int[] currConditions = new int[4];
		int start = 0;
		int end = P - 1;
		int count = 0;
		int index;

		for (index = start; index <= end; index++) {
			if (input[index] == 'A') {
				currConditions[0]++;
			} else if (input[index] == 'C') {
				currConditions[1]++;
			} else if (input[index] == 'G') {
				currConditions[2]++;
			} else if (input[index] == 'T') {
				currConditions[3]++;
			}
		}

		if (checkConditions(conditions, currConditions)) {
			count++;
		}

		for (int i = 0; i < S - P; i++) {
			char startChar = input[start++];
			char endChar = input[++end];

			if (startChar == 'A') {
				currConditions[0]--;
			} else if (startChar == 'C') {
				currConditions[1]--;
			} else if (startChar == 'G') {
				currConditions[2]--;
			} else if (startChar == 'T') {
				currConditions[3]--;
			}

			if (endChar == 'A') {
				currConditions[0]++;
			} else if (endChar == 'C') {
				currConditions[1]++;
			} else if (endChar == 'G') {
				currConditions[2]++;
			} else if (endChar == 'T') {
				currConditions[3]++;
			}

			if (checkConditions(conditions, currConditions)) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static boolean checkConditions(int[] conditions, int[] currConditions) {
		for (int i = 0; i < 4; i++) {
			if (conditions[i] > currConditions[i]) {
				return false;
			}
		}
		return true;
	}

}
