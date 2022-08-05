// data : 2202-08-03
// link : https://www.acmicpc.net/source/47142503
/*
  해쉬 이용한 문제 해결
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> poketNum = new HashMap<String, String>();
		HashMap<String, String> poketName = new HashMap<String, String>();
		
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			String num = Integer.toString(i);
			poketNum.put(name, num);
			poketName.put(num, name);
		}
		
		for(int i = 0; i < M; i++) {
			String temp = br.readLine();
			String num = poketNum.getOrDefault(temp, null);
			String name = poketName.getOrDefault(temp, null);
			
			if(num == null) {
				sb.append(name).append('\n');
			} else {
				sb.append(num).append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
