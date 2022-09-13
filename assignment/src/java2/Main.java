package java2;

import java.io.IOException;

class Main {

	public static void main(String[] args) throws IOException {

		int[] A = new int[15];

		for (int i = 0; i < A.length; i++) {
			A[i] = (int) (Math.random() * 100);
		}

		quick_sort(A, 0, A.length - 1);

		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	public static void quick_sort(int[] A, int start, int end) {
		if (start >= end) {
			return;
		}

		int startIndex = start;
		int endIndex = end;
		int pivot = A[startIndex];
		int temp;

		while (startIndex < endIndex) {
			while (startIndex < endIndex && A[startIndex] <= pivot) {
				startIndex++;
			}
			while (startIndex < endIndex && A[endIndex] > pivot) {
				endIndex--;
			}
			temp = A[startIndex];
			A[startIndex] = A[endIndex];
			A[endIndex] = temp;
		}

		A[start] = A[startIndex];
		A[startIndex] = pivot;

		quick_sort(A, start, startIndex - 1);
		quick_sort(A, startIndex + 1, end);
	}
}