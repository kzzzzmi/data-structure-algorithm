package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[3];
		num[0] = Integer.parseInt(st.nextToken());
		num[1] = Integer.parseInt(st.nextToken());
		num[2] = Integer.parseInt(st.nextToken());

		int day = 1;
		while(day % num[0] != 0 || day % num[1] != 0 || day % num[2] != 0) {
			day++;
		}
		
		
		System.out.println(day);
		System.out.println(System.currentTimeMillis() - start);
	}

}