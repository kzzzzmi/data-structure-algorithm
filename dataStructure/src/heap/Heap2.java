package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap2 {
	
	public ArrayList<Integer> heapArray;
	
	public Heap2() {
		heapArray = new ArrayList<Integer>();
		heapArray.add(null);
	}
	
	public Integer pop() {
		if(heapArray == null || heapArray.size() <= 1) {
			return null;
		}
		
		int returnData = heapArray.get(1);
		heapArray.set(1, heapArray.get(heapArray.size() - 1));
		heapArray.remove(heapArray.size() - 1);

		int poppedIdx, leftChildIdx, rightChildIdx;
		poppedIdx = 1;
		
		while(isMoveDown(poppedIdx)) {
			leftChildIdx = poppedIdx * 2;
			rightChildIdx = poppedIdx * 2 + 1;
			
			if(rightChildIdx >= heapArray.size()) {
				Collections.swap(heapArray, poppedIdx, leftChildIdx);
				poppedIdx = leftChildIdx;
			} else {
				if(heapArray.get(leftChildIdx) > heapArray.get(rightChildIdx)) {
					Collections.swap(heapArray, poppedIdx, leftChildIdx);
					poppedIdx = leftChildIdx;
				} else {
					Collections.swap(heapArray, poppedIdx, rightChildIdx);
					poppedIdx = rightChildIdx;
				}
			}
		}
		
		return returnData;
	}
	
	public boolean isMoveDown(int poppedIdx) {
		int leftChildIdx = poppedIdx * 2;
		int rightChildIdx = poppedIdx * 2 + 1;
		
		if(leftChildIdx >= heapArray.size()) {
			return false;
		} else if(rightChildIdx >= heapArray.size()) {
			if(heapArray.get(poppedIdx) < heapArray.get(leftChildIdx)) {
				return true;
			} else {
				return false;
			}
		} else {
			if(heapArray.get(leftChildIdx) > heapArray.get(rightChildIdx)) {
				if(heapArray.get(poppedIdx) < heapArray.get(leftChildIdx)) {
					return true;
				} else {
					return false;
				}
			} else {
				if(heapArray.get(poppedIdx) < heapArray.get(rightChildIdx)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	public boolean insertHeap(int data) {
		if(heapArray == null) {
			heapArray = new ArrayList<Integer>();
			heapArray.add(null);
			heapArray.add(data);
			return true;
		}
		
		if(heapArray.size() <= 1) {
			heapArray.add(data);
			return true;
		}
		
		heapArray.add(data);
		int dataIdx = heapArray.size() - 1;
		int parentIdx;
		
		while(isMoveUp(dataIdx)) {
			parentIdx = dataIdx / 2;
			Collections.swap(heapArray, dataIdx, parentIdx);
			dataIdx = parentIdx;
		}
		
		return true;
	}
	
	public boolean isMoveUp(int dataIdx) {
		if(dataIdx <= 1) {
			return false;
			
		}
		int parentIdx = dataIdx / 2;
		if(heapArray.get(dataIdx) > heapArray.get(parentIdx)) {
			return true;
		}
		return false;
	}
}
