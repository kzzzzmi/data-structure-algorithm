package linkedList;

public class SingleLinkedList<T> {
	private Node<T> head = null;
	
	private class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public void addNode(T data) {
		if(head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> node = this.head;
			while(node.next != null) {
				node = node.next;				
			}
			node.next = new Node<>(data);
		}
	}
	
	public void printAll() {
		if(head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}

}
