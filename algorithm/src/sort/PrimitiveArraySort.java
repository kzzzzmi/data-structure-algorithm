package sort;

public class PrimitiveArraySort {

	static int[] sorted;
	
	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		mergeSort(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public static void mergeSort(int[] arr) {
		sorted = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1);
		sorted = null;
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		if(start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		
		mergeSort(arr, start , mid, end);
	}
	
	public static void mergeSort(int[] arr, int start, int mid, int end) {
		
	}

}
