package algorithmSolving;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		ArrayList<Integer> array = new ArrayList<>();
		
		while(size > 0) {
			array.add(Integer.parseInt(br.readLine()));
			size--;
		}
		array = mergeSplitFunc(array);
		
		for(int i = 0 ; i < array.size(); i++) {
			sb.append(array.get(i)).append('\n');
		}
		System.out.println(sb);
		
	}
	
	public static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> array) {
		if(array.size() <= 1) {
			return array;
		}
		int mid = array.size() / 2;
		
		ArrayList<Integer> leftArray = mergeSplitFunc(new ArrayList<>(array.subList(0, mid)));
		ArrayList<Integer> rightArray = mergeSplitFunc(new ArrayList<>(array.subList(mid, array.size())));
		
		return mergeFunc(leftArray, rightArray);
	}
	
	public static ArrayList<Integer> mergeFunc(ArrayList<Integer> leftArray, ArrayList<Integer> rightArray) {
		int left = 0;
		int right = 0;
		ArrayList<Integer> mergeArray = new ArrayList<>();
		
		while(left < leftArray.size() && right < rightArray.size()) {
			if(leftArray.get(left) < rightArray.get(right)) {
				mergeArray.add(leftArray.get(left++));
			} else {
				mergeArray.add(rightArray.get(right++));
			}
		}
		
		while(left < leftArray.size()) {
			mergeArray.add(leftArray.get(left++));
		}
		while(right < rightArray.size()) {
			mergeArray.add(rightArray.get(right++));
		}
		
		leftArray = null;
		rightArray = null;
		return mergeArray;
	}
}