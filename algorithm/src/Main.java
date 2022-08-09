import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[N][N];
		int value;
		
		st = new StringTokenizer(br.readLine());
		
		arr[0][0] = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {
			value = Integer.parseInt(st.nextToken());
			arr[0][i] += arr[0][i - 1] + value;
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				value = Integer.parseInt(st.nextToken());
				if(j == 0) {
					arr[i][j] = arr[i-1][j] + value;
				} else {
					arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + value;
				}
			}
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			sb.append(answer(arr, x1, y1, x2, y2)).append('\n');
		}
		
		System.out.println(sb);
	}	
	
	public static int answer(int[][] arr, int x1, int y1, int x2, int y2) {
		if(x1 == 0 && y1 == 0) {
			return arr[x2][y2];
		} else if(x1 == 0 && y1 != 0) {
			return arr[x2][y2] - arr[x2][y1-1];
		} else if(y1 == 0 && x1 != 0) {
			return arr[x2][y2] - arr[x1-1][y2];
		} else {
			return arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
		}
		
	}
}
