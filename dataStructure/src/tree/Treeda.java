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
		
		Node findNode = this.head;
		Node parentNode = this.head;
		
		if(findNode.value == data) {
			this.head = null;
			return true;
		}
		
		while(findNode != null) {
			if(findNode.value == data) {
				if(findNode.left == null && findNode.right == null) {
					if(data < parentNode.value) {
						parentNode.left = null;
					} else {
						parentNode.right = null;
					}
				} else if(findNode.left != null && findNode.right != null) {
					if(data < parentNode.value) {
						Node changeNode = findNode.right;
						Node changeParentNode = findNode;
						if(changeNode.left == null) {
							if(changeNode.right == null) {
								parentNode.left = changeNode;
								changeParentNode.right = null;
							} else {
								changeParentNode.right = changeNode.right;
								parentNode.left = changeNode;
							}
						}
						while(true) {
							if(changeNode.left == null) {
								parentNode.left = changeNode;
								changeParentNode.left = null;
							} else {
								changeParentNode = changeNode;
								changeNode = changeNode.left;
							} 
						}
					} else {
						
					}
				} else {
					if(data < parentNode.value) {
						if(findNode.left != null) {
							parentNode.left = findNode.left;
						} else {
							parentNode.left = findNode.right;
						}
					} else {
						if(findNode.left != null) {
							parentNode.right = findNode.left;
						} else {
							parentNode.right = findNode.right;
						}
					}
				}
				return true;
			}
			if(data < findNode.value) {
				parentNode = findNode;
				findNode = findNode.left;
			} else {
				parentNode = findNode;
				findNode = findNode.right;
			}
		}
	}

}
