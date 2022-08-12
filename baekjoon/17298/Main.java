// data : 2202-08-12
// link : https://www.acmicpc.net/source/47611960
/*
  priority queue를 이용한 문제해결
   - 생각해내기 힘듦
   - 끝나고 다른 사람들 풀이를 보니 stack으로 풀었는데 저게 정석인듯
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Index implements Comparable<Index> {
	int index;
	int value;
	
	public Index(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
	@Override
	public int compareTo(Index o) {
		return this.value - o.value;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Index> minHeap = new PriorityQueue<Index>();
		int[] inputs = new int[N];
		int[] answer = new int[N];

		for(int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
			answer[i] = -1;
			minHeap.add(new Index(i, inputs[i]));
			
			while(minHeap.peek().value < inputs[i]) {
				Index index = minHeap.poll();
				answer[index.index] = inputs[i];
			}
		}
		
		for(int i : answer) {
			sb.append(i).append(' ');
		}

		System.out.println(sb);
	}

}
