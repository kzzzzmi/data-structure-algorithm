import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int min = 1000001;
		int count = 1;
		int index = 0;
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
			if(A[i] < min) {
				min = A[i];
				index = i;
			}
		}
		
		count += index;
		
		for(int i = index + 1; i < N; i++) {
			if(A[i] > A[i + 1]) {
				count++;
			}
		}
		
		System.out.println(count);
=======
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
>>>>>>> 6e62409ea6cbe806ccf256b7eeffed4bf2c0dd0a
	}

}