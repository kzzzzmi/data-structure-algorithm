package algorithmSolving;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("물건의 갯수 : ");
		int I = Integer.parseInt(br.readLine());
		System.out.print("무게 제한 : ");
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		ArrayList<Thing> things = new ArrayList<>();
		for(int i = 0; i < I; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			things.add(new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(things, new Comparator<Thing>() {
			@Override
			public int compare(Thing t1, Thing t2) {
				if(t1.realValue > t2.realValue) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		double answer = greedy(things, K);	
		System.out.println((int)(answer * 10 + 0.5) / (double)10);
	}
	
	public static double greedy(ArrayList<Thing> things, int limit) {
		int currentWeight = 0;
		int currentValue = 0;
		int i = -1;
		while(currentWeight < limit) {
			i++;
			currentWeight += things.get(i).weight;
			currentValue += things.get(i).value;
		}
		currentWeight -= things.get(i).weight;
		currentValue -= things.get(i).value;
		
		double plusValue = things.get(i).realValue * (limit - currentWeight);
		return currentValue + plusValue;
	}
	
}

class Thing {
	int weight;
	int value;
	double realValue;
	
	public Thing(int weight, int value) {
		this.weight = weight;
		this.value = value;
		this.realValue = (double)value / weight;
	}
	
	public String toString() {
		return this.weight + ", " + this.value;
	}
}