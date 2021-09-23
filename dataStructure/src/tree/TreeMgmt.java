package tree;

class Node {
	Node left;
	Node right;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

public class TreeMgmt {
	Node head;

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

	public Node searchNode(int data) {
		if (this.head == null) {
			return null;
		}
		Node findNode = this.head;
		while (findNode != null) {
			if (findNode.data == data) {
				return findNode;
			}
			if (data < findNode.data) {
				findNode = findNode.left;
			} else {
				findNode = findNode.right;
			}
		}
		return null;

	}

	public boolean delete(int data) {
		boolean searched = false;

		Node currParentNode = this.head;
		Node currNode = this.head;

		// case1 : Node가 하나도 없을 때
		if (this.head == null) {
			return false;
			
			// case2 : Node 가 단지 하나만 있고, 해당 Node가 삭제할 Node일 때
		} else if (this.head.data == data && this.head.left == null && this.head.right == null) {
			this.head = null;
			return true;
		} else {
			while (currNode != null) {
				if (currNode.data == data) {
					searched = true;
					break;
				} else if (data < currNode.data) {
					currParentNode = currNode;
					currNode = currNode.left;
				} else {
					currParentNode = currNode;
					currNode = currNode.right;
				}
			}

			if (searched == false) {
				return false;
			}
		}

		// 여기 구문까지 실행되면
		// currNode는 해당 데이터를 가지고 있는 Node가 있고
		// currParentNode는 그 Node의 부모 Node가 있음

		// case1 : 삭제할 Node가 Leaf Node일 때
		if(currNode.left == null && currNode.right == null) {
			if(data < currParentNode.data) {
				currParentNode.left = null;
				currNode = null;
			} else {
				currParentNode.right = null;
				currNode = null;
			}
			return true;
			// 삭제할 Node가 child Node를 한 개 가지고 있을 떄
		} else if(currNode.left != null && currNode.right == null) {
			if(data < currParentNode.data) {
				currParentNode.left = currNode.left;
				currNode = null;
			} else {
				currParentNode.right = currNode.left;
				currNode = null;
			}
			return true;
		} else if(currNode.left == null && currNode.right != null) {
			if(data < currParentNode.data) {
				currParentNode.left = currNode.right;
				currNode = null;
			} else {
				currParentNode.right = currNode.right;
				currNode = null;
			}
			return true;
		}
	}

}
