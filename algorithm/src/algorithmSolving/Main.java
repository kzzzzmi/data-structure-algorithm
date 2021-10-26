package algorithmSolving;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������ ���� : ");
		int I = Integer.parseInt(br.readLine());
		System.out.print("���� ���� : ");
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		ArrayList<Thing> things = new ArrayList<>();
		for(int i = 0; i < I; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			things.add(new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(things);
		
		double answer = greedy(things, K);	
		System.out.println(answer);
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

class Thing implements Comparable {
	int weight;
	int value;
	double realValue;
	
	public Thing(int weight, int value) {
		this.weight = weight;
		this.value = value;
		this.realValue = (double)value / weight;
	}
	
	public int compareTo(Object ob) {
		Thing t = (Thing)ob;
		if(this.realValue > t.realValue) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public String toString() {
		return this.weight + ", " + this.value;
	}
}