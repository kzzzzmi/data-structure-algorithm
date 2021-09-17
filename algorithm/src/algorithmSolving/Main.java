package algorithmSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			System.out.println(teleportNum(y - x));
		}
		
	}
	
	public static int teleportNum(int len) {
		if(len <= 3) {
			return len;
		}
		
		int temp = len;
		
		int i;
		int cnt = 0;
		int sum = 0;
		for(i = 1; i <= Math.floor(Math.sqrt(len)); i++) {
			sum += i;
			temp -= i;
			cnt++;
		}
		i--;
		
		while(temp >= sum) {
			temp -= i;
			cnt++;
		}
		i--;
		
		sum = 0;
		while(i != 0) {
			sum += i;
			i--;
			cnt++;
		}
		
		if(sum != temp) {
			cnt++;
		}	
		return cnt;
	}

}
