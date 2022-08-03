// data : 2202-08-03
// link : https://www.acmicpc.net/source/47146438
/*
  해쉬셋을 이용한 중복되는 원소 제거
*/

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.HashSet;
	
	
	public class Main {
	
		public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			HashSet<String> set = new HashSet<String>();
			
			String str = br.readLine();
			int size = str.length();
			
			for(int i = 1; i <= size; i++) {
				int index = i;
				for(int j = 0; j <= size - i; j++) {
					set.add(str.substring(j, index++));
				}
			}
			
			System.out.println(set.size());
		}
	}
