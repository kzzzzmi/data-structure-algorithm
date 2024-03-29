// data : 2202-08-02
// link : https://www.acmicpc.net/source/47079364
/*
  priority queue를 이용한 절대값으로 비교하는 최소힙
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int o1Abs = Math.abs(o1);
				int o2Abs = Math.abs(o2);
				
				if(o1Abs != o2Abs) {
					return o1Abs - o2Abs;
				} else {
					return (o1 > o2) ? 1 : -1;
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int num;
		
		for(int i = 0 ; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(priorityQueue.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(priorityQueue.poll()).append('\n');
				}
			} else {
				priorityQueue.add(num);
			}
		}
		
		System.out.println(sb);
	}
}
