package tree;

public class MainTest1 {

	public static void main(String[] args) {

		Treeda tree = new Treeda();
		tree.insertNode(10);
		tree.insertNode(15);
		tree.insertNode(13);
		tree.insertNode(18);
		tree.insertNode(7);

		System.out.println(tree.delete(10));
		System.out.println("HEAD : " + tree.head.value);

		System.out.println("HEAD LEFT : " + tree.head.left.value);
//		System.out.println("HEAD LEFT LEFT : " + tree.head.left.left.value);
//		System.out.println("HEAD LEFT RIGHT : " + tree.head.left.right.value);

		System.out.println("HEAD RIGHT : " + tree.head.right.value);
//		System.out.println("HEAD RIGHT LEFT : " + tree.head.right.left.value);
//		System.out.println("HEAD RIGHT LEFT RIGHT : " + tree.head.right.left.right.value);
		System.out.println("HEAD RIGHT RIGHT : " + tree.head.right.right.value);
		/*
		 * System.out.println("HEAD RIGHT RIGHT LEFT : " +
		 * tree.head.right.right.left.value);
		 * System.out.println("HEAD RIGHT RIGHT LEFT RIGHT : " +
		 * tree.head.right.right.left.right.value);
		 * System.out.println("HEAD RIGHT RIGHT RIGHT : " +
		 * tree.head.right.right.right.value);
		 */
	}

}
