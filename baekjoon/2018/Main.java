// data : 2202-09-01
// link : https://www.acmicpc.net/source/48596590
/*
  투 포인터 기본적인 개념
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 1;
		int start = 1;
		int end = 1;
		int sum = 1;

		while (end < N) {
			if (sum < N) {
				sum += ++end;
			} else if (sum > N) {
				sum -= start++;
			} else {
				sum += ++end;
				count++;
			}
		}

		System.out.println(count);
	}

}
