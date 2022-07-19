import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringTokenizer stA;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			arr = new int[b];
			
			stA = new StringTokenizer(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < b; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			sb.append(solution(stA)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int solution(StringTokenizer st) {
		int sum = 0;
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			sum += binarySearch(num);
		}
		
		return sum;
	}
	
	public static int binarySearch(int num) {		
		int start = 0;
		int end = arr.length - 1;
		int mid = end / 2;
		while(true) {
			if(start == end && arr[start] != num) {
				break;
			}
			mid = (start + end) / 2;
			if(num == arr[mid]) {
				return arr[mid];
			} else if(num < arr[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		if(mid != arr.length - 1) {
			int dif1 = Math.abs(arr[mid] - num);
			int dif2 = Math.abs(arr[mid+1] - num);
			return dif1 <= dif2 ? arr[mid] : arr[mid+1];
		}
		
		if(mid != 0) {
			int dif1 = Math.abs(arr[mid] - num);
			int dif2 = Math.abs(arr[mid-1] - num);
			return dif1 <= dif2 ? arr[mid] : arr[mid-1];
		}

		return arr[mid];
	}

}
