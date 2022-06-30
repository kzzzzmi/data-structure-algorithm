package tree;

public class Treeda {
	
	Node head;
	
	public class Node {
		Node left;
		Node right;
		int value;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	public boolean insertNode(int value) {
		if(this.head == null) {
			this.head = new Node(value);
		} else {
			Node findNode = this.head;
			
			while(true) {
				if(value < findNode.value) {
					if(findNode.left != null) {
						findNode = findNode.left;
					} else {
						findNode.left = new Node(value);
						break;
					}
				} else {
					if(findNode.right != null) {
						findNode = findNode.right;
					} else {
						findNode.right = new Node(value);
						break;
					}
				}
			}
		}
		return true;
	}
	
}
