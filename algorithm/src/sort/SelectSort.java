package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> array = new ArrayList<>();
		
		for(int i = 0; i < 15; i++) {
			int num = (int)(Math.random() * 100) + 1;
			array.add(num);
		}
		System.out.println(array);
		selectSort(array);
		System.out.println(array);
		
	}
	
	public static void selectSort(ArrayList<Integer> array) {
		for(int i = 0; i < array.size() - 1; i++) {
			int index = i;
			for(int j = i + 1; j < array.size(); j++) {
				if(array.get(index) > array.get(j)) {
					index = j;
				}
//				if(array.get(i) > array.get(j)) {
//					array.set(i, array.set(j, array.get(i)));
//				}
			}
			Collections.swap(array, i, index);
		}
	}

}
