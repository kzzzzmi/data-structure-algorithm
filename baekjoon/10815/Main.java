// data : 2202-08-03
// link : https://www.acmicpc.net/source/47139933
/*
  HashMap을 통한 숫자 확인
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> isNum = new HashMap<String, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			isNum.put(st.nextToken(), 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			sb.append(isNum.getOrDefault(st.nextToken(), 0)).append(' ');
		}
		
		System.out.println(sb);
		
	}
}
