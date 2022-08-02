// data : 2202-08-02
// link : https://www.acmicpc.net/source/47083755
/*
  binary search를 통한 삽입 정렬 및 중간 숫자 찾기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		ArrayList<Integer> array = new ArrayList<Integer>(N);
		int num;

		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			int index = Collections.binarySearch(array, num);
			int findIndex = -(index + 1);

			if (index < 0) {
				array.add(findIndex, num);
			} else {
				array.add(index, num);
			}

			int size = array.size();

			if (size % 2 == 0) {
				sb.append(array.get(size / 2 - 1)).append('\n');
			} else {
				sb.append(array.get(size / 2)).append('\n');
			}
		}

		System.out.println(sb);
	}
}
