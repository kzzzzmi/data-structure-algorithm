package algorithmSolving;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(br.readLine());
		System.out.printf("%.6f\n", uArea(R));
		System.out.printf("%.6f", tArea(R));
		
	}
	
	public static double uArea(int R) {
		return (double)Math.round(Math.PI * Math.pow(R, 2) * 1000000) / 1000000;
	}
	
	public static double tArea(int R) {
		return 2 * Math.pow(R, 2);
	}

}
