package tree;

public class Treeda {

	Node head;

	class Node {
		Node left;
		Node right;
		int value;

		Node(int value) {
			this.value = value;
		}
	}

	public boolean insertNode(int value) {
		if (this.head == null) {
			this.head = new Node(value);
		} else {
			Node findNode = this.head;

			while (true) {
				if (value < findNode.value) {
					if (findNode.left != null) {
						findNode = findNode.left;
					} else {
						findNode.left = new Node(value);
						break;
					}
				} else {
					if (findNode.right != null) {
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

	public Node search(int data) {
		Node findNode = this.head;
		while (findNode != null) {
			if (findNode.value == data) {
				return findNode;
			}
			if (data < findNode.value) {
				findNode = findNode.left;
			} else {
				findNode = findNode.right;
			}
		}
		return null;
	}
	
	public boolean delete(int data) {
		if(this.head == null) {
			return false;
		}
		
		if(this.head.value == data) {
			if(this.head.left == null && this.head.right == null) {
				this.head = null;
				return true;
			} else if(this.head.left != null && this.head.right == null) {
				this.head = this.head.left;
				return true;
			} else if(this.head.left == null && this.head.right != null) {
				this.head = this.head.right;
				return true;
			} else {
				Node headNode = this.head;
				Node changeNode = this.head.right;
				Node changeParentNode = this.head.right;
				
				while(changeNode.left != null) {
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				
				if(changeNode.right != null) {
					changeParentNode.left = changeNode.right;
				} else {
					changeParentNode.left = null;
				}
				
				this.head = changeNode;
				this.head.left = headNode.left;
				this.head.right = headNode.right;
				return true;
			}
		}
		
		Node currNode = this.head;
		Node currParentNode = this.head;
		boolean searched = false;
		
		while(currNode != null) {
			if(currNode.value == data) {
				searched = true;
				break;
			} else if(data < currNode.value) {
				currParentNode = currNode;
				currNode = currNode.left;
			} else {
				currParentNode = currNode;
				currNode = currNode.right;
			}
		}
		
		if(searched == false) {
			return false;
		}
		
		if(currNode.left == null && currNode.right == null) {
			if(data < currParentNode.value) {
				currParentNode.left = null;
			} else {
				currParentNode.right = null;
			}
			currNode = null;
			return true;
		} else if(currNode.left != null && currNode.right == null) {
			if(data < currParentNode.value) {
				currParentNode.left = currNode.left;
			} else {
				currParentNode.right = currNode.left;
			}
			currNode = null;
			return true;
		} else if(currNode.left == null && currNode.right != null) {
			if(data < currParentNode.value) {
				currParentNode.left = currNode.right;
			} else {
				currParentNode.right = currNode.right;
			}
			currNode = null;
			return true;
		} else {
			Node changeNode = currNode.right;
			Node changeParentNode = currNode.right;
			
			while(changeNode.left != null) {
				changeParentNode = changeNode;
				changeNode = changeNode.left;
			}
			
			if(changeNode.right != null) {
				changeParentNode.left = changeNode.right;
			} else {
				changeParentNode.left = null;
			}
			
			if(data < currParentNode.value) {
				currParentNode.left = changeNode;
			} else {
				currParentNode.right = changeNode;
			}
			changeNode.left = currNode.left;
			changeNode.right = currNode.right;
			return true;
		}
	}

}
