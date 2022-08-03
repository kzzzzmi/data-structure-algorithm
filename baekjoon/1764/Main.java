// data : 2202-08-03
// link : https://www.acmicpc.net/source/47143516
/*
  해쉬셋과 문자열 정렬을 이용한 문제 해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> arr = new ArrayList<String>();
		int count = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			arr.add(br.readLine());
		}
		
		Collections.sort(arr);
		
		for(String str : arr) {
			if(set.contains(str)) {
				sb.append(str).append('\n');
				count++;
			}
		}

		sb.insert(0, count + "\n");
		System.out.println(sb);
	}
}
