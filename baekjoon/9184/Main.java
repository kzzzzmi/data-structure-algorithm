// data : 2202-08-05
// link : https://www.acmicpc.net/source/47258540
/*
  Dynamic Programing
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		dpFunc();

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			String notation = "w(" + a + ", " + b + ", " + c + ") = ";
			if (a <= 0 || b <= 0 || c <= 0) {
				sb.append(notation + 1).append('\n');
			} else if (a > 20 || b > 20 || c > 20) {
				sb.append(notation + dp[20][20][20]).append('\n');
			} else {
				sb.append(notation + dp[a][b][c]).append('\n');
			}

		}
		System.out.println(sb);
	}

	public static void dpFunc() {
		initDp();

		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				for (int k = 1; k <= 20; k++) {
					if (i < j && j < k) {
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					} else {
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
								- dp[i - 1][j - 1][k - 1];
					}
				}
			}
		}
	}
	
	public static void initDp() {
		for(int i = 0; i < 21; i++) {
			for(int j = 0; j < 21; j++) {
				dp[0][i][j] = 1;
				dp[i][0][j] = 1;
				dp[i][j][0] = 1;
			}
		}
	}

}
