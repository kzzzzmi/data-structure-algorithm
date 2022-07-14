package sort;

import java.util.ArrayList;
import java.util.Collections;

public class MySort {

	public ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {
		for (int i = 0; i < array.size() - 1; i++) {
			boolean swap = false;

			for (int j = 0; j < array.size() - 1 - i; j++) {
				if (array.get(j) > array.get(j + 1)) {
					Collections.swap(array, j, j + 1);
					swap = true;
				}
			}

			if (!swap) {
				break;
			}
		}
		return array;
	}

	public ArrayList<Integer> insertionSort(ArrayList<Integer> array) {
		for (int i = 1; i < array.size(); i++) {
			int index = i;
			while (index >= 1 && array.get(index) < array.get(index - 1)) {
				Collections.swap(array, index, index - 1);
				index--;
			}
		}
		return array;
	}

	public ArrayList<Integer> selectionSort(ArrayList<Integer> array) {
		for (int i = 0; i < array.size() - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < array.size(); j++) {
				if (array.get(j) < array.get(minIdx)) {
					minIdx = j;
				}
			}
			if (minIdx != i) {
				Collections.swap(array, i, minIdx);
			}
		}
		return array;
	}
	
	public static ArrayList<Integer> splitArray(ArrayList<Integer> array) {
		if(array.size() <= 1) {
			return array;
		}
		int mid = array.size() / 2;
		ArrayList<Integer> leftArr = splitArray(new ArrayList<Integer>(array.subList(0, mid)));
		ArrayList<Integer> rightArr = splitArray(new ArrayList<Integer>(array.subList(mid, array.size())));
		
		return mergeArr(leftArr, rightArr);
	}
	
	public static ArrayList<Integer> mergeArr(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
		ArrayList<Integer> mergeArr = new ArrayList<Integer>();
		int leftIdx = 0;
		int rightIdx = 0;
		
		while(leftIdx < leftArr.size() && rightIdx < rightArr.size()) {
			if(leftArr.get(leftIdx) < rightArr.get(rightIdx)) {
				mergeArr.add(leftArr.get(leftIdx++));
			} else {
				mergeArr.add(rightArr.get(rightIdx++));
			}
		}
		
		if(leftIdx >= leftArr.size()) {
			while(rightIdx < rightArr.size()) {
				mergeArr.add(rightArr.get(rightIdx++));
			}
		}
		if(rightIdx >= rightArr.size()) {
			while(leftIdx < leftArr.size()) {
				mergeArr.add(leftArr.get(leftIdx++));
			}
		}
		
		return mergeArr;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			arr.add((int)(Math.random() * 100 + 1));
		}
		
		arr = splitArray(arr);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

}