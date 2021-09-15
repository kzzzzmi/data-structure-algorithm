package linkedList;

public class DoubleLinkedList<T> {
	
	public Node<T> head = null;
	public Node<T> tail = null;
	
	public class Node<T> {
		T data;
		Node<T> prev = null;
		Node<T> next = null;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public void addNode(T data) {
		if(head == null) {
			this.head = new Node<T>(data);
			this.tail = this.head;
		} else {
			Node<T> node = this.head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(data);
			node.next.prev = node;
			this.tail = node.next;
		}
	}
	
	public void printAll() {
		if(this.head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}
	
	public T searchFromHead(T isData) {
		Node<T> node = this.head;
		while(node != null) {
			if(node.data == isData) {
				return node.data;
			}
			node = node.next;
		}
		return null;
	}
	
	public T searchFromTail(T isData) {
		Node<T> node = this.tail;
		while(node != null) {
			if(node.data == isData) {
				return node.data;
			}
			node = node.prev;
		}
		return null;
	}
	
	public boolean insertToBack(T existedData, T addData) {
		if(this.head == null) {
			this.head = new Node<T>(addData);
			this.tail = this.head;
			return true;
		} else if(this.tail.data == existedData) {
			this.tail.next = new Node<T>(addData);
			this.tail.next.prev = this.tail;
			this.tail = this.tail.next;
			return true;
		}
		Node<T> node = this.head;
		while(node != null) {
			if(node.data == existedData) {
				node.next.prev = new Node<T>(addData);
				node.next.prev.next = node.next;
				node.next = node.next.prev;
				node.next.prev = node;
				return true;
			}
			node = node.next;
		}
		this.tail.next = new Node<T>(addData);
		this.tail.next.prev = this.tail;
		this.tail = this.tail.next;
		return true;
	}
	
	public boolean insertToFront(T existedData, T addData) {
		if(this.head == null) {
			this.head = new Node<T>(addData);
			this.tail = this.head;
			return true;
		} else if(this.head.data == existedData) {
			Node<T> newHead = new Node<T>(addData);
			newHead.next = this.head;
			this.head.prev = newHead;
			this.head = newHead;
			return true;
		}
		Node<T> node = this.head;
		while(node != null) {
			if(node.data == existedData) {
				Node<T> nodePrve = node.prev;
				nodePrve.next = new Node<T>(addData);
				nodePrve.next.prev = nodePrve.next;
				nodePrve = nodePrve.next;
				nodePrve.next = node;
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
}













