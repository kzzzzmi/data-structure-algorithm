package tree;

public class TreeMgmt {
	Node head;

	class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public boolean insertNode(int data) {
		if (this.head == null) {
			this.head = new Node(data);
		} else {
			Node findNode = this.head;
			while (true) {
				if (data < findNode.data) {
					if (findNode.left != null) {
						findNode = findNode.left;
					} else {
						findNode.left = new Node(data);
						break;
					}
				} else {
					if (findNode.right != null) {
						findNode = findNode.right;
					} else {
						findNode.right = new Node(data);
						break;
					}
				}
			}
		}
		return true;
	}

}
