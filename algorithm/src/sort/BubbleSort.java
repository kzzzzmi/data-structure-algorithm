package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BubbleSort {
	
	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>();
		Random random = new Random();
		
//		for(int i = 0; i < 20; i++) {
//			int data = (int)(Math.random() * 100) + 1;
//			array.add(data);
//		}
		for(int i = 0; i < 20; i++) {
			int data = random.nextInt(45) + 1;
			array.add(data);
		}
			
		bubbleSort(array);
		
		System.out.println(array);
		
	}
	
	public static void bubbleSort(ArrayList<Integer> array) {
		for(int i = 0; i < array.size() - 1; i++) {
			boolean swap = false;
			for(int j = 0; j < array.size() - i - 1; j++) {
				if(array.get(j) > array.get(j + 1)) {
					Collections.swap(array, j, j + 1);
					swap = true;
				}
			}
			if(swap == false) {
				break;
			}
		}
	}

}
