package algorithmSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD

public class Main {
	
	static int funcCount = 1;
=======
import java.util.ArrayList;

>>>>>>> 49f911d374a427addc75b94351764a995965fbbf

public class Main {
	
	static ArrayList<String> cases = new ArrayList<>();
	static String answer;
	
	public static void main(String[] args) throws IOException {
<<<<<<< HEAD
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] fibonacci = new int[41];
		fibonacci[1] = 1;
		fibonacci[2] = 1;
		
		int fibCount = 0;
		for(int i = 3; i <= num; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
			fibCount++;
		}
		fibonacci(num);
		
		System.out.println(funcCount + " " + fibCount);
	}
	
	public static int fibonacci(int num) {
		if(num <= 2) {
			return 1;
		}
		funcCount++;
		return fibonacci(num - 1) + fibonacci(num - 2);
=======

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
>>>>>>> 49f911d374a427addc75b94351764a995965fbbf
	}
}