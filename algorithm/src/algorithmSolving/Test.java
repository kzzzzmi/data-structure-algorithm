package algorithmSolving;

import java.io.*;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
		}
		br.close();
		
		System.out.println(sb);
		
	}
}
