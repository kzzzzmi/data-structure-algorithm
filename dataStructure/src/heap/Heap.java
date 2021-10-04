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
		if (data_idx <= 1) {
			return false;
		}
		int parent_idx = data_idx / 2;
		if (heapArray.get(data_idx) > heapArray.get(parent_idx)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean moveDown(int poped_idx) {
		int left_child, right_child;

		left_child = poped_idx * 2;
		right_child = poped_idx * 2 + 1;
		if (left_child >= heapArray.size()) {
			return false;
		}
		// case : 왼쪽 자식 노드만 있을 떄
		else if (right_child >= heapArray.size()) {
			if (heapArray.get(poped_idx) < heapArray.get(left_child)) {
				return true;
			}
		}
		// case : 오른쪽 자식노드도 있을 때
		else {
			if (heapArray.get(left_child) > heapArray.get(right_child)) {
				if (heapArray.get(left_child) > heapArray.get(poped_idx)) {
					return true;
				}
			} else {
				if(heapArray.get(right_child) > heapArray.get(poped_idx)) {
					return true;
				}
			}
		}
		return false;
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

		while (moveUp(data_idx)) {
			int parent_idx = data_idx / 2;
			Collections.swap(heapArray, data_idx, parent_idx);
			data_idx = parent_idx;
		}
		return true;
	}

	public ArrayList<Integer> getHeapArray() {
		return heapArray;
	}

	public Integer pop() {
		if (heapArray == null) {
			return null;
		}
		int returned_idx, left_child_idx, right_child_idx, poped_idx;
		returned_idx = heapArray.get(1);
		heapArray.set(1, heapArray.get(heapArray.size() - 1));
		heapArray.remove(heapArray.size() - 1);
		poped_idx = 1;

		while (moveDown(poped_idx)) {
			left_child_idx = poped_idx * 2;
			right_child_idx = poped_idx * 2 + 1;

			// case : 왼쪽 노드 자식만 있을 때
			if (right_child_idx >= heapArray.size()) {
				Collections.swap(heapArray, left_child_idx, poped_idx);
				poped_idx = left_child_idx;
			} else {
				if (heapArray.get(left_child_idx) > heapArray.get(right_child_idx)) {
					Collections.swap(heapArray, left_child_idx, poped_idx);
					poped_idx = left_child_idx;
				} else {
					Collections.swap(heapArray, right_child_idx, poped_idx);
					poped_idx = right_child_idx;
				}
			}			
		}
		return returned_idx;
	}

}
