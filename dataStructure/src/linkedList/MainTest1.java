package linkedList;

public class MainTest1 {

	public static void main(String[] args) {

		SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
		
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);		
		linkedList.printAll();
		System.out.println();
		
		linkedList.addNode(3, 6);
		linkedList.addNode(4, 7);
		linkedList.addNode(5, 8);
		linkedList.printAll();
		System.out.println();
		
		linkedList.deleteNode(1);
		linkedList.printAll();
		System.out.println();
		
		linkedList.deleteNode(3);
		linkedList.printAll();
		System.out.println();
		
		linkedList.deleteNode(4);
		linkedList.printAll();
		System.out.println();
		
		linkedList.deleteNode(8);
		linkedList.printAll();
		System.out.println();
		
	}

}
