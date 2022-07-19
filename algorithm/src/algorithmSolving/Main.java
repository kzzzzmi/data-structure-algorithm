package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	
	static ArrayList<String> cases = new ArrayList<>();
	static String answer;
	
	public static void main(String[] args) throws IOException {

		boolean flag = true;
		int gameCount = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = br.readLine();
		initCase();
		
		while(flag) {
			
		}

	}
	
	public static void initCase() {
		int num = 123;		
		while(num < 988) {
			if(!overlapCheck(num)) {
				cases.add(Integer.toString(num));
			}
			num++;
		}
	}
	
	public static boolean overlapCheck(int num) {
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