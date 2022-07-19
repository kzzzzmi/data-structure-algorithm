package sort;

import java.util.ArrayList;

public class Merge {
	
	static int[] mergedArr;

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		int[] arr = new int[100];
		for(int i = 0; i < 100; i++) {
			int num = (int)(Math.random() * 100);
			array.add(num);
			arr[i] = num;
		}
		System.out.println(array);
		array = mergeSplit(array);
		System.out.println(array);
		System.out.println("--------------------------------------");
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		merge(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	// 기본 배열 merge 정렬
	public static void merge(int[] array) {
		mergedArr = new int[array.length];
		
		mergeSplit(array, 0, array.length - 1);
		mergedArr = null;
	}
	
	public static void mergeSplit(int[] array, int start, int end) {
		if(start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		mergeSplit(array, start, mid);
		mergeSplit(array, mid + 1, end);
		
		mergeConquer(array, start, mid, end);
	}
	
	public static void mergeConquer(int[] array, int start, int mid, int end) {
		int leftIdx = start;
		int rightIdx = mid + 1;
		int mergedIdx = leftIdx;
		
		while(leftIdx <= mid && rightIdx <= end) {
			if(array[leftIdx] < array[rightIdx]) {
				mergedArr[mergedIdx++] = array[leftIdx++];
			} else {
				mergedArr[mergedIdx++] = array[rightIdx++];
			}
		}
		
		if(leftIdx > mid) {
			while(rightIdx <= end) {
				mergedArr[mergedIdx++] = array[rightIdx++];
			}
		}
		
		if(rightIdx > end) {
			while(leftIdx <= mid) {
				mergedArr[mergedIdx++] = array[leftIdx++];
			}
		}
		
		for(int i = start; i <= end; i++) {
			array[i] = mergedArr[i];
		}
	}
	
	
	// ArrayList 배열 merge 정렬
	public static ArrayList<Integer> mergeSplit(ArrayList<Integer> array) {
		if(array.size() == 1) {
			return array;
		}
		
		int mid = array.size() / 2;
		ArrayList<Integer> leftArr = mergeSplit(new ArrayList<Integer>(array.subList(0, mid)));
		ArrayList<Integer> rightArr = mergeSplit(new ArrayList<Integer>(array.subList(mid, array.size())));
		
		return mergeConquer(leftArr, rightArr);
	}
	
	public static ArrayList<Integer> mergeConquer(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
		ArrayList<Integer> mergedArr = new ArrayList<Integer>();
		
		int leftIdx = 0;
		int rightIdx = 0;
		
		while(leftIdx < leftArr.size() && rightIdx < rightArr.size()) {
			if(leftArr.get(leftIdx) < rightArr.get(rightIdx)) {
				mergedArr.add(leftArr.get(leftIdx++));
			} else {
				mergedArr.add(rightArr.get(rightIdx++));
			}
		}
		
		if(leftIdx >= leftArr.size()) {
			while(rightIdx < rightArr.size()) {
				mergedArr.add(rightArr.get(rightIdx++));
			}
		}
		
		if(rightIdx >= rightArr.size()) {
			while(leftIdx < leftArr.size()) {
				mergedArr.add(leftArr.get(leftIdx++));
			}
		}
		
		return mergedArr;
	}

}
