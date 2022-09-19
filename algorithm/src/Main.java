import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int[] mergedArr;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(A);

		System.out.println(count);

	}

	public static void mergeSort(int[] array) {
		mergedArr = new int[array.length];
		mergeSort(array, 0, array.length - 1);
		mergedArr = null;
	}

	public static void mergeSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;

		mergeSort(array, left, mid);
		mergeSort(array, mid + 1, right);

		merge_conquer(array, left, mid, right);
	}

	public static void merge_conquer(int[] array, int left, int mid, int right) {
		int lo = left;
		int hi = mid + 1;
		int index = left;

		while (lo <= mid && hi <= right) {
			if (array[lo] <= array[hi]) {
				mergedArr[index++] = array[lo++];
			} else {
				count += hi - index;
				mergedArr[index++] = array[hi++];
			}
		}

		while (lo <= mid) {
			mergedArr[index++] = array[lo++];
		}
		while (hi <= right) {
			mergedArr[index++] = array[hi++];
		}

		for (int i = left; i <= right; i++) {
			array[i] = mergedArr[i];
		}
	}

}