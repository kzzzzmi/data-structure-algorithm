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
	
	public void addNode(T isData, T data) {
		Node<T> searchNode = searchNode(isData);
		if(searchNode == null) {
			addNode(data);
		}
		Node<T> nextNode = searchNode.next;
		searchNode.next = new Node<T>(data);
		searchNode.next.next = nextNode;
	}
	
	public Node<T> searchNode(T data) {
		if(head == null) {
			return null;
		} else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.data == data) {
					return node;
				}
				node = node.next;
			}
			return null;
		}
	}
	
	public boolean deleteNode(T data) {
		if(this.head == null) {
			return false;
		}
		if(this.head.data == data) {
			this.head = this.head.next;
		}
		
		Node<T> node = this.head;
		while(node.next != null) {
			if(node.next.data == data) {
				node.next = node.next.next;
				return true;
			}
			node = node.next;
		}
		return false;
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
