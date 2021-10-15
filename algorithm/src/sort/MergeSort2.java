package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort2 {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 4, 3, 2));
		System.out.println(array);
		array = mergeSplitFunc(array);
		System.out.println(array);
	}
	
	public static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> arrayList) {
		if(arrayList.size() <= 1) {
			return arrayList;
		}
		
		int mid = arrayList.size() / 2;
		
		ArrayList<Integer> leftArray = mergeSplitFunc(new ArrayList<Integer>(arrayList.subList(0, mid)));
		ArrayList<Integer> rightArray = mergeSplitFunc(new ArrayList<Integer>(arrayList.subList(mid, arrayList.size())));
		
		return mergeFunc(leftArray, rightArray);
	}
	
	public static ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArray, ArrayList<Integer> rightArray) {
		int leftPoint = 0, rightPoint = 0;
		ArrayList<Integer> array = new ArrayList<>();
		
		while(leftPoint < leftArray.size() && rightPoint < rightArray.size()) {
			if(leftArray.get(leftPoint) > rightArray.get(rightPoint)) {
				array.add(rightArray.get(rightPoint));
				rightPoint++;
			} else {
				array.add(leftArray.get(leftPoint));
				leftPoint++;
			}
		}
		
		while(leftPoint < leftArray.size()) {
			array.add(leftArray.get(leftPoint));
			leftPoint++;
		}
		while(rightPoint < rightArray.size()) {
			array.add(rightArray.get(rightPoint));
			rightPoint++;
		}
		return array;
	}

}
