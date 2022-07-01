package tree;

public class MainTest1 {

	public static void main(String[] args) {

//		TreeMgmt myTree = new TreeMgmt();
//		myTree.insertNode(2);
//		myTree.insertNode(3);
//		myTree.insertNode(6);
//		myTree.insertNode(1);
//		
//		Node node = myTree.searchNode(3);
//		System.out.println(node.left.data);
		
		Treeda tree = new Treeda();
		tree.insertNode(2);
		tree.insertNode(3);
		tree.insertNode(6);
		tree.insertNode(1);
		
		tree.Treeda.Node node = tree.search(3);
		System.out.println(node.value);
		
	}

}
