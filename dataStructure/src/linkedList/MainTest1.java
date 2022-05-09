package linkedList;

public class MainTest1 {

	public static void main(String[] args) {

		SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
		
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		
		linkedList.printAll();
		
	}

}
