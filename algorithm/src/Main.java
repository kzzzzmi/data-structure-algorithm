import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
	
	static HashSet<Integer> checkNum = new HashSet<Integer>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
						
		PriorityQueue<Integer> measures = new PriorityQueue<Integer>();
		int[] arr = new int[N];
		int minNum = Integer.MAX_VALUE;
		int value;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] < minNum) {
				minNum = arr[i];
			}
		}
		
		measures = getMeasure(minNum);
		measures.remove(1);
		
		while(!measures.isEmpty()) {
			value = measures.poll();
			checkNum.add(value);
			
			boolean equalCheck = true;
			int standardRes = arr[0] % value;
			for(int i = 1; i < arr.length; i++) {
				int temp = arr[i] % value;
				if(temp != standardRes) {
					equalCheck = false;
				}
				if(!measures.contains(temp) && !checkNum.contains(temp) && temp != 0) {
					measures.add(temp);
				}
			}
			
			if(equalCheck) {
				sb.append(value).append(' ');
			}
		}
		System.out.println(sb);
		
	}
	
	public static PriorityQueue<Integer> getMeasure(int minNum) {
		PriorityQueue<Integer> measures = new PriorityQueue<Integer>();
		int sqrt = (int)Math.sqrt(minNum);
		
		for(int i = 1; i <= sqrt; i++) {
			if(minNum % i == 0) {
				measures.add(i);
				measures.add(minNum / i);
				checkNum.add(i);
				checkNum.add(minNum / i);
			}
		}
		return measures;
		
	}

}
