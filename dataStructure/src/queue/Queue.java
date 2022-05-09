package queue;

import java.util.ArrayList;

public class Queue<T> {
	private ArrayList<T> queue;
	
	public Queue() {
		queue = new ArrayList<T>();
	}
	
	public void enqueue(T data) {
		queue.add(data);
	}
	
	public T dequeue() {
		if(queue.isEmpty()) {
			return null;
		}
		return queue.remove(0);
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public int size() {
		return queue.size();
	}

}
