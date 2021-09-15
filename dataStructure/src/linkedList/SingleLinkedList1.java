package linkedList;

public class SingleLinkedList1<T> {
	public Node<T> head = null;

	public class Node<T> {
		T data;
		Node<T> next = null;

		public Node(T data) {
			this.data = data;
		}
	}

	public boolean deleteNode(T data) {
		if (this.head == null) {
			return false;
		}
		Node<T> node = head;
		if (node.data == data) {
			this.head = node.next;
			return true;
		}
		while (node.next != null) {
			if (node.next.data == data) {
				node.next = node.next.next;
				return true;
			}
			node = node.next;
		}

		return false;
	}

	public void addNode(T data) {
		if (head == null) {
			this.head = new Node<T>(data);
		} else {
			Node<T> node = this.head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(data);
		}
	}

	public void addNode(T data, T isData) {
		Node<T> searchNode = searchNode(isData);

		if (searchNode == null) {
			this.addNode(data);
		} else {
			Node<T> nextNode = searchNode.next;
			searchNode.next = new Node<T>(data);
			searchNode.next.next = nextNode;
		}
	}

	public Node<T> searchNode(T data) {
		if (this.head == null) {
			return null;
		}
		Node<T> node = head;
		while (node != null) {
			if (node.data == data) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public void printAll() {
		if (head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while (node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}

}
