// data : 2202-08-12
// link : https://www.acmicpc.net/source/48454733
/*
  queue를 활용한 문제
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	
	static class Document {
		int num;
		int value;
		
		public Document(int num, int value) {
			this.num = num;
			this.value = value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		boolean isPrinted;
		LinkedList<Document> documents;
		Document document;
		int N, M, count;
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());			
			documents = new LinkedList<Document>();
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				documents.add(new Document(i, Integer.parseInt(st.nextToken())));
			}
			
			count = 1;
			while(!documents.isEmpty()) {
				isPrinted = true;
				document = documents.poll();
				
				for(int i = 0; i < documents.size(); i++) {
					if(document.value < documents.get(i).value) {
						documents.add(document);
						for(int j = 0; j < i; j++) {
							documents.add(documents.poll());
						}				
						isPrinted = false;
						break;
					}
				}
				
				if(isPrinted) {
					if(document.num == M) {
						sb.append(count).append('\n');
						break;
					}
					count++;
				}
			}
						
		}
		
		System.out.println(sb);
	}

}
