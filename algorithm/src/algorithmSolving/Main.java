package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] arr = new int[2][n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < n; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = arr[0][i];
		}
		
		Arrays.sort(arr[0]);
		
		int rank = 0;
		for(int i : arr[0]) {
			if(!map.containsKey(i)) {
				map.put(i, rank++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(map.get(arr[1][i])).append(" ");
		}
		System.out.println(sb);
	}

}