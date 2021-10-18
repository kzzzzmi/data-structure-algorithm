package search;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			array.add((int)(Math.random() * 100 + 1));
		}
		Collections.sort(array);
		System.out.println(array);
		
		System.out.println(binarySearch(array, 13));

	}
	
	public static int binarySearch(ArrayList<Integer> array, int item) {
		if(array.size() == 0) {
			return -1;
		}
		if(array.size() <= 1 && array.get(0) != item) {
			return -1;
		}
		
		int mid = array.size() / 2;
		
		if(array.get(mid) == item) {
		 	return item;
		} else if(array.get(mid) > item){
			return binarySearch(new ArrayList<>(array.subList(0, mid)), item);
		} else {
			return binarySearch(new ArrayList<>(array.subList(mid, array.size())), item);
		}
	}
}
