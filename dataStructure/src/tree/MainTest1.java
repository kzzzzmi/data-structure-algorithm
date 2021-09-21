package tree;

public class MainTest1 {

	public static void main(String[] args) {

		TreeMgmt myTree = new TreeMgmt();
		myTree.insertNode(2);
		myTree.insertNode(3);
		myTree.insertNode(6);
		myTree.insertNode(1);
		
		Node node = myTree.searchNode(3);
		System.out.println(node.left.data);
		
	}

}
