import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		int[] s = new int[N + 1];
		int start, end;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			s[i] = s[i - 1] + arr[i];
		}
		
		while(M > 0) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());		
			
			sb.append(s[end] - s[start - 1]).append('\n');
			
			M--;
		}
		
		System.out.println(sb);
	}

}
