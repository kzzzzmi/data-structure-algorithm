package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Testet {
	
	static boolean[] num = new boolean[10];
	static ArrayList<String> cases = new ArrayList<>();
	
	static String answer;
	static int strike;
	static int ball;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		answer = br.readLine();

		while(true) {
			
			if(strike + ball == 0) {
				
			}
		}
		
	}
	
	public static void getStrikeBall(String choice) {
		for(int i = 0; i < 3; i++) {
			if(answer.charAt(i) == choice.charAt(i)) {
				strike++;
			}
			for(int j = 0; j < 3; j++) {
				if(i != j && answer.charAt(j) == answer.charAt(i)) {
					ball++;
				}
			}
		}
	}
	
	public static void initCase() {
		int num = 123;		
		while(num < 988) {
			if(!checkOverlap(num)) {
				cases.add(Integer.toString(num));
			}
			num++;
		}
	}
	
	public static boolean checkOverlap(int num) {
		int[] temp = new int[3];
		temp[0] = num / 100;
		temp[1] = num / 10 % 10;
		temp[2] = num % 10;
		
		if(temp[0] == temp[1] || temp[0] == temp[2] || temp[1] == temp[2]) {
			return true;
		}
		if(temp[0] == 0 || temp[1] == 0 || temp[2] == 0) {
			return true;
		}
		return false;
	}

}
