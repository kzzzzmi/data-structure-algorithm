package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
	private ArrayList<Integer> heapArray;

	public Heap() {
		heapArray = new ArrayList<>();
		heapArray.add(null);
	}
	
	private boolean moveUp(int data_idx) {
		if(data_idx <= 1) {
			return false;
		}
		int parent_idx = data_idx / 2;
		if(heapArray.get(data_idx) > heapArray.get(parent_idx)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean insert(int data) {
		if (heapArray == null) {
			heapArray = new ArrayList<Integer>();
			heapArray.add(null);
			heapArray.add(data);
			return true;
		}
		heapArray.add(data);
		int data_idx = heapArray.size() - 1;
		
		while(moveUp(data_idx)) {
			int parent_idx = data_idx / 2;
			Collections.swap(heapArray, data_idx, parent_idx);
			data_idx = parent_idx;
		}
		return true;
	}

	public ArrayList<Integer> getHeapArray() {
		return heapArray;
	}

}
