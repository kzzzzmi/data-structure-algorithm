package linkedList;

public class DoubleLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public class Node<T> {
		Node<T> prev;
		Node<T> next;
		T data;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public void addNode(T data) {
		if(head == null) {
			this.head = new Node<T>(data);
			this.tail = this.head;
		} else {
			this.tail.next = new Node<T>(data);
			this.tail.next.prev = this.tail;
			this.tail = this.tail.next;
		}
	}
	
	public void printAll() {
		Node<T> node = this.head;
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	public T searchFromHead(T data) {
		if(this.head == null) {
			return null;
		}
		Node<T> node = this.head;
		while(node != null) {
			if(node.data == data) {
				return node.data;
			}
			node = node.next;
		}
		return null;
	}
	
	public T searchFromTail(T data) {
		if(this.head == null) {
			return null;
		}
		Node<T> node = this.tail;
		while(node != null) {
			if(node.data == data) {
				return node.data;
			}
			node = node.prev;
		}
		return null;
	}
	
	public boolean insertToFront(T isData, T data) {
		if(this.head == null) {
			this.head = new Node<T>(data);
			this.tail = this.head;
			return true;
		}
		if(this.head.data == isData) {
			Node<T> node = new Node<T>(data);
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
			return true;
		}
		Node<T> node = this.head.next;
		while(node != null) {
			if(node.data == isData) {
				Node<T> prev = node.prev;
				prev.next = new Node<T>(data);
				prev.next.next = node;
				node.prev = prev.next;
				prev.next.prev = prev;
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
}