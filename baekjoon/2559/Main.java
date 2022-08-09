// data : 2202-08-09
// link : https://www.acmicpc.net/source/47450361
/*
  누적합 구현
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		int maxSum = 0, currSum = 0;
		int index;
		
		st = new StringTokenizer(br.readLine());
		
		for(index = 0; index < K; index++) {
			num[index] = Integer.parseInt(st.nextToken());
			currSum += num[index];
		}
		maxSum = currSum;
		
		while(index < N) {
			num[index] = Integer.parseInt(st.nextToken());
			currSum += num[index] - num[index - K];
			
			maxSum = maxSum > currSum ? maxSum : currSum;
			index++;
		}
		
		System.out.println(maxSum);
	}	
}
