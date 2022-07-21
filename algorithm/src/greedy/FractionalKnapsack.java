package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FractionalKnapsack {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] objects = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			objects[i][0] = Integer.parseInt(st.nextToken()); // 무게
			objects[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}

		Arrays.sort(objects, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] / o1[0] > o2[1] / o2[0]) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		knapsackGreedy(objects, k);
	}

	public static void knapsackGreedy(int[][] objects, int k) {
		double sumValue = 0;
		for (int i = 0; i < objects.length; i++) {
			if (objects[i][0] <= k) {
				sumValue += objects[i][1];
				k -= objects[i][0];
			} else {
				System.out.println(objects[i][0]);
				System.out.println(objects[i][1]);
				sumValue += (double) k / objects[i][0] * objects[i][1];
				break;
			}
		}
		System.out.println(sumValue);
	}

}