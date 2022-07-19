package search;

import java.util.Arrays;

public class BinarySearch2 {

	public static void main(String[] args) {
		int[] array = new int[50];
		for(int i = 0; i < 50; i++) {
			array[i] = (int)(Math.random() * 100);
		}
		Arrays.sort(array);
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(binarySearch(array, 1));
	}
	
	public static int binaryRecursiveSearch(int[] array, int start, int end, int num) {
		if(start == end && array[start] != num) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if(array[mid] == num) {
			return num;
		} else if(array[mid] < num) {
			return binaryRecursiveSearch(array, mid + 1, end, num);
		} else {
			return binaryRecursiveSearch(array, start, mid, num);
		}
	}
	
	public static int binarySearch(int[] array, int find) {
		int start = 0;
		int end = array.length - 1;
		
		while(true) {
			if(start == end && array[start] != find) {
				return -1;
			}
			int mid = (start + end) / 2;
			
			if(find == array[mid]) {
				return find;
			} else if(find < array[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
	}

}
