package sort;

import java.util.ArrayList;
import java.util.Collections;

public class MySort {
	
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {		
		for(int i = 0; i < array.size() - 1; i++) {
			boolean swap = false;
			
			for(int j = 0; j < array.size() - 1 - i; j++) {
				if(array.get(j) > array.get(j + 1)) {
					Collections.swap(array, j, j + 1);
					swap = true;
				}
			}
			
			if(!swap) {
				break;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		MySort sort = new MySort();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			array.add((int)(Math.random() * 100 + 1));
		}
		
		sort.bubbleSort(array);
		
		for(int i : array) {
			System.out.print(i);
		}
	}
	
}