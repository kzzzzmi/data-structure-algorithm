// data : 2202-08-03
// link : https://www.acmicpc.net/source/47144636
/*
  해쉬맵을 이용한 문제해결
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
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		int count = 0;
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < A; i++) {
			hashMap.put(st.nextToken(), 1);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < B; i++) {
			String temp = st.nextToken();
			if(hashMap.containsKey(temp)) {
				hashMap.put(temp, 2);
			} else {
				hashMap.put(temp, 1);
			}
		}
		
		for(String str : hashMap.keySet()) {
			if(hashMap.get(str) == 1) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
