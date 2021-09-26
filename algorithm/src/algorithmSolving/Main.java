package algorithmSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		boolean[][] board = new boolean[row+1][col+1];
		
		for(int i = 1; i <= row; i++) {
			String wb = br.readLine();
			for(int j = 1; j <= col; j++) {
				if(wb.charAt(j) == 'W') {
					board[i][j] = true;
				}
			}
		}
		
		int rowT = row - 7;
		int colT = col - 7;
		int cnt = 0;
		boolean index = false;
		
		while(rowT > 0) {
			for(int i = rowT; i < rowT + 7; i++) {
				for(int j = colT; j < colT + 7; j++) {
					if(board[i][j] == board[i+1][j+1]) {
						cnt++;
					}
				}
			}
			if(colT > 1) {
				colT--;
			} else if(colT == 1){
				rowT--;
				colT = col - 7;
			}
		}
		
		
	}
	
}