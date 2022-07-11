package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		
		int[][] array = new int[w + 1][h + 1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int length = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(d == 0) {
				int currY = y;
				for(int j = 0; j < length; j++) {
					array[x][currY++] = 1;
				}
			} else {
				int currX = x;
				for(int j = 0; j < length; j++) {
					array[currX++][y] = 1;
				}
			}
		}
		
		for(int i = 1; i < array.length; i++) {
			for(int j = 1; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}