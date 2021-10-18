package search;

import java.util.ArrayList;

public class SequencialSearch {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			array.add((int)(Math.random() * 100 + 1));
		}
		
		System.out.println(searchItem(array, 15));
		System.out.println(searchItem(array, 500));
	}
	
	public static int searchItem(ArrayList<Integer> array, int item) {
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i) == item) {
				return array.get(i);
			}
		}
		return -1;
	}

}
