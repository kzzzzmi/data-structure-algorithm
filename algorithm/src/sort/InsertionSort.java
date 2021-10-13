package sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 0; i < 50; i++) {
			array.add((int)(Math.random() * 100 + 1));
		}
		System.out.println(array);
		InsertionSort(array);
		System.out.println(array);
	}
	
	public static void InsertionSort(ArrayList<Integer> array) {
		for(int i = 0; i < array.size() - 1; i++) {
			int index = i + 1;
			while(index > 0 && array.get(index) < array.get(index - 1)) {
				Collections.swap(array, index, index - 1);
				index--;
			}
		}
	}

}
