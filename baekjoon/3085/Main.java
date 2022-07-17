// data : 2202-07-18
// link : https://www.acmicpc.net/source/46215212
/*
  처음 구현했을 때는 교환할 때마다 모든 배열에 접근해서 최대 사탕 갯수를 찾음
  이후 바뀐 열과 행만 탐색하면 된다는 것을 검색을 통해 알게됨
  리팩토링을 통해 코드를 개선함
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new char[N][N];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int maxCandyNum = 1;
		int candyNum = 1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j < N - 1) {
					colSwap(i, j);
					candyNum = colCheckNum(i, j);

					if (candyNum > maxCandyNum) {
						maxCandyNum = candyNum;
					}
					if (maxCandyNum == N) {
						break;
					}
					colSwap(i, j);
				}

				if (i < N - 1) {
					rowSwap(i, j);
					candyNum = rowCheckNum(i, j);

					if (candyNum > maxCandyNum) {
						maxCandyNum = candyNum;
					}
					if (maxCandyNum == N) {
						break;
					}
					rowSwap(i, j);
				}
			}

			if (maxCandyNum == N) {
				break;
			}
		}
		System.out.println(maxCandyNum);
	}

  // 매번 완전 탐색으로 최대 갯수를 찾는 기능
//	public static int candyNum(int row, int col) {
//	int num = 1;
//	int rowMax = 1;
//	int colMax = 1;
//	for (int i = 0; i < board[0].length; i++) {
//		for (int j = 0; j < board[i].length - 1; j++) {
//			if (board[i][j] == board[i][j + 1]) {
//				num++;
//			} else {
//				rowMax = (rowMax > num ? rowMax : num);
//				num = 1;
//			}
//		}
//		rowMax = (rowMax > num ? rowMax : num);
//		num = 1;
//	}
//
//	for (int i = 0; i < board.length; i++) {
//		for (int j = 0; j < board.length - 1; j++) {
//			if (board[j][i] == board[j + 1][i]) {
//				num++;
//			} else {
//				colMax = (colMax > num ? colMax : num);
//				num = 1;
//			}
//		}
//		colMax = (colMax > num ? colMax : num);
//		num = 1;
//	}
//
//	return (rowMax > colMax) ? rowMax : colMax;
//}

	public static int colCheckNum(int x, int y) {
		int maxCandyNum = 1;
		int candyNum = 1;

		for (int i = 0; i < board.length - 1; i++) {
			if (board[x][i] == board[x][i + 1]) {
				candyNum++;
				if (candyNum > maxCandyNum) {
					maxCandyNum = candyNum;
				}
			} else {
				candyNum = 1;
			}
		}
		if (maxCandyNum == board.length) {
			return maxCandyNum;
		}

		candyNum = 1;
		for (int i = 0; i < board.length - 1; i++) {
			if (board[i][y] == board[i + 1][y]) {
				candyNum++;
				if (candyNum > maxCandyNum) {
					maxCandyNum = candyNum;
				}
			} else {
				candyNum = 1;
			}
		}
		if (maxCandyNum == board.length) {
			return maxCandyNum;
		}

		candyNum = 1;
		for (int i = 0; i < board.length - 1; i++) {
			if (board[i][y + 1] == board[i + 1][y + 1]) {
				candyNum++;
				if (candyNum > maxCandyNum) {
					maxCandyNum = candyNum;
				}
			} else {
				candyNum = 1;
			}
		}

		return maxCandyNum;
	}

	public static int rowCheckNum(int x, int y) {
		int maxCandyNum = 1;
		int candyNum = 1;

		for (int i = 0; i < board.length - 1; i++) {
			if (board[i][y] == board[i + 1][y]) {
				candyNum++;
				if (candyNum > maxCandyNum) {
					maxCandyNum = candyNum;
				}
			} else {
				candyNum = 1;
			}
		}
		if (maxCandyNum == board.length) {
			return maxCandyNum;
		}

		candyNum = 1;
		for (int i = 0; i < board.length - 1; i++) {
			if (board[x][i] == board[x][i + 1]) {
				candyNum++;
				if (candyNum > maxCandyNum) {
					maxCandyNum = candyNum;
				}
			} else {
				candyNum = 1;
			}
		}
		if (maxCandyNum == board.length) {
			return maxCandyNum;
		}

		candyNum = 1;
		for (int i = 0; i < board.length - 1; i++) {
			if (board[x + 1][i] == board[x + 1][i + 1]) {
				candyNum++;
				if (candyNum > maxCandyNum) {
					maxCandyNum = candyNum;
				}
			} else {
				candyNum = 1;
			}
		}

		return maxCandyNum;
	}

	public static void colSwap(int i, int j) {
		char temp = board[i][j];
		board[i][j] = board[i][j + 1];
		board[i][j + 1] = temp;
	}

	public static void rowSwap(int i, int j) {
		char temp = board[i][j];
		board[i][j] = board[i + 1][j];
		board[i + 1][j] = temp;
	}

}
