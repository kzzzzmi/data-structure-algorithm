package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int count = 1;
		while(count != N) {
			num++;
			int currNum = num;
			while(currNum >= 666) {
				if(currNum % 1000 == 666) {
					count++;
					break;
				}
				currNum /= 10;				
			}			
		}
		System.out.println(num);
	}
}
