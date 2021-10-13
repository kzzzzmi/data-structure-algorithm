package sort;

import java.util.Arrays;

public class MergeSort {
	static int[] tempArr;
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 77, 6, 8, 5, 9, 11, 5795, 77, 5, 6, 8};
		merge(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		
	}
	
	public static void merge(int[] arr) {
		tempArr = new int[arr.length];
		merge_div(arr, 0, arr.length - 1);
		tempArr = null;
	}
	
	public static void merge_div(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		if(mid > start) {
			merge_div(arr, start, mid);
			merge_div(arr, mid + 1, end);
		}
		
		merge_conquer(arr, start, end);
	}
	
	public static void merge_conquer(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		int left = start;
		int right = mid + 1;
		int index = start;
		
		while(left <= mid && right <= end) {
			if(arr[left] < arr[right]) {
				tempArr[index] = arr[left];
				index++;
				left++;
			} else {
				tempArr[index] = arr[right];
				index++;
				right++;
			}
		}
		
		if(left > mid) {
			for(int i = right; i <= end; i++) {
				tempArr[index] = arr[i];
				index++;
			}
		}
		if(right > end) {
			for(int i = left; i <= mid; i++) {
				tempArr[index] = arr[i];
				index++;
			}
		}
		
		for(int i = start; i <= end; i++) {
			arr[i] = tempArr[i];
		}
	}

}
