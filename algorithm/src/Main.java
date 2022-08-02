import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] num = new int[26];
		int size = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();

		int max = 0;
		char maxChar = 'a';
		for(int i = 0; i < size; i++) {
			int temp = ++num[str[i] - 'a'];
			if(max < temp) {
				max = temp;
				maxChar = str[i];
			}
		}
		
		System.out.println(sb.append(maxChar).append(' ').append(max));
	}
}
