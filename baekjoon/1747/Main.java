// data : 2202-11-01
// link : https://www.acmicpc.net/source/51208773
/*
  에라토스테네스의 체와 완전 탐색
*/
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] P = new boolean[1003002];
		ArrayList<Integer> A = new ArrayList<Integer>();
		char[] temp;
		int start, end;
		int answer = 0;
		boolean find = false;

		P[1] = true;
		for (int i = 2; i * i < P.length; i++) {
			if (!P[i]) {
				for (int j = i * 2; j < P.length; j += i) {
					P[j] = true;
				}
			}
		}

		for (int i = N; i < P.length; i++) {
			if (!P[i]) {
				A.add(i);
			}
		}

		for (int num : A) {
			temp = Integer.toString(num).toCharArray();
			start = 0;
			end = temp.length - 1;

			while (true) {
				if (temp[start] != temp[end]) {
					break;
				}
				start++;
				end--;

				if (start > end) {
					answer = num;
					find = true;
					break;
				}
			}

			if (find) {
				break;
			}
		}

		System.out.println(answer);
	}

}
