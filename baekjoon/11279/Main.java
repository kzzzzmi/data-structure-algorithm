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
				return o2 - o1;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int num;
		
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(priorityQueue.size() == 0) {
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
