// data : 2202-09-01
// link : https://www.acmicpc.net/source/48598767
/*
  array를 활용한 문제 해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] materials = new boolean[100001];
		int temp;
		int count = 0;
			
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			temp = Integer.parseInt(st.nextToken());
			materials[temp] = true;

			if(M % 2 == 0 && M / 2 <= 100000) {
				materials[M / 2] = false;
			}
			
			if(temp < M && M - temp <= 100000 && materials[M - temp]) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
