package algorithmSolving;

import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int H;
	static int W;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		ArrayList<Nemo> nemo = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nemo.add(new Nemo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(nemo);
		
		int area = maxArea(nemo);		
		System.out.println(area);
		
	}
	
	public static int maxArea(ArrayList<Nemo> nemo) {
		for(int i = 0; i < nemo.size() - 1; i++) {
			Nemo o = nemo.get(i);
			int x = o.width;
			int y = o.height;
			if(checkRange(x, y)) {
				continue;
			}
			for(int j = i + 1; j < nemo.size(); j++) {
				Nemo n = nemo.get(j);
				if(checkRange(n.width, n.height)) {
					continue;
				}
				if(((n.width <= W && n.height <= H - y) || (n.width <= W - x && n.height <= H)) || 
						((n.width <= W && n.height <= H - x) || (n.width <= W - y && n.height <= H))) {
					return (o.width * o.height) + (n.width * n.height);
				} else if(((n.height <= W && n.width <= H - y) || (n.height <= W - x && n.width <= H)) || 
						((n.height <= W && n.width <= H - x) || (n.height <= W - y && n.width <= H))) {
					return (o.width * o.height) + (n.width * n.height);
				}
			}
		}
		return 0;
	}
	
	public static boolean checkRange(int x, int y) {
		if((x >= W && y >= W) || (x >= H && y >= H)) {
			return true;
		}
		return false;
	}
	
}

class Nemo implements Comparable {
	int width;
	int height;
	
	public Nemo(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int compareTo(Object ob) {
		Nemo n = (Nemo)ob;
		if(this.width * this.height > n.width * n.height) {
			return -1;
		} else {
			return 1;
		}
	}
}