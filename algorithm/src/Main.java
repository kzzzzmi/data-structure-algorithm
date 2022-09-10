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
	}

}