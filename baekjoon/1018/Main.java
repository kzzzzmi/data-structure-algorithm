import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static char[][] board;
	static char[][] chess = new char[8][8];
	static int minChangeNum;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		
		for(int i = 0; i < board.length; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		minChangeNum = Integer.MAX_VALUE;
		
		for(int i = 0; i + 8 <= board.length; i++) {
			for(int j = 0; j + 8 <= board[i].length; j++) {
				initChess(i, j);
				getChangeNum();
			}
		}
		
		System.out.println(minChangeNum);
	}
	
	public static void getChangeNum() {
		int w_start = 0;
		int b_start = 0;
		
		for(int i = 0; i < chess.length; i++) {
			for(int j = 0; j < chess[i].length; j++) {
				char temp = chess[i][j];
				if(i % 2 == 0) {
					if(j % 2 == 0) {
						if(temp == 'W') {
							b_start++;
						} else {
							w_start++;
						}
					} else {
						if(temp == 'W') {
							w_start++;
						} else {
							b_start++;
						}
					}
				} else {
					if(j % 2 == 0) {
						if(temp == 'B') {
							b_start++;
						} else {
							w_start++;
						}
					} else {
						if(temp == 'B') {
							w_start++;
						} else {
							b_start++;
						}
					}
				}
			}
		}
		int temp = b_start > w_start ? w_start : b_start;
		minChangeNum = minChangeNum > temp ? temp : minChangeNum;
	}
	
	public static void initChess(int x, int y) {
		int y_idx = y;
		
		for(int i = 0; i < 8; i++, x++) {
			y_idx = y;
			for(int j = 0; j < 8; j++, y_idx++) {
				chess[i][j] = board[x][y_idx];
			}
		}
	}
}
