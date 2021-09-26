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

		// case1 : Node�� �ϳ��� ���� ��
		if (this.head == null) {
			return false;
			
			// case2 : Node �� ���� �ϳ��� �ְ�, �ش� Node�� ������ Node�� ��
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

		// ���� �������� ����Ǹ�
		// currNode�� �ش� �����͸� ������ �ִ� Node�� �ְ�
		// currParentNode�� �� Node�� �θ� Node�� ����

		// case1 : ������ Node�� Leaf Node�� ��
		if(currNode.left == null && currNode.right == null) {
			if(data < currParentNode.data) {
				currParentNode.left = null;
				currNode = null;
			} else {
				currParentNode.right = null;
				currNode = null;
			}
			return true;
			// case2 : ������ Node�� child Node�� �� �� ������ ���� ��
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
			// case 3-1 : ������ Node�� Child Node �� �� �� ������ ���� ��
		} else {
			// ������ Node�� �θ� Node�� ���ʿ� ���� ��
			if(data < currParentNode.data) {
				Node changeNode = currNode.right;
				Node changeParentNode = currNode.right;
				while(changeNode != null) {
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				// changeNode ���� ������ Node�� ������ Node ��
				// ���� ���� ���� ���� Node�� ��� ����
				
				if(changeNode.right != null) {
					changeParentNode.left = changeNode.right;
				} else {
					changeParentNode.left = null;
				}
				// curParentNode �� ���� child Node ��, ������ Node�� ������ �ڽ���
				// ���� ���� ���� ���� changeNode�� ����
				currParentNode.left = changeNode;
				
				// parentNode�� ���� child�� ����, changeNode�̰�
				// changeNode�� ����/������ child Node�� ��� ������ currNode��
				// ���� ������ Node�� ��������� ��
				changeNode.left = currNode.left;
				changeNode.right = currNode.right;
				
				currNode = null;
			} else {
				Node changeNode = currNode.right;
				Node changeParentNode = currNode.right;
				while(changeNode != null) {
					changeParentNode = changeNode;
					changeNode = changeNode.left;
				}
				
				if(changeNode.right != null) {
					changeParentNode.left = changeNode.right;
				} else {
					changeParentNode.left = null;
				}
				
				currParentNode.right = changeNode;
				
				changeNode.left = currNode.left;
				changeNode.right = currNode.right;
				
				currNode = null;
			}
			return true;
		}
	}

}
