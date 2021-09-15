package linkedList;

public class MainTest1 {

	public static void main(String[] args) {

		SingleLinkedList1<Integer> myList = new SingleLinkedList1<>();
		myList.addNode(1);
		myList.addNode(2);
		myList.addNode(3);
		
		myList.addNode(5, 1);
		myList.addNode(6, 3);
		myList.addNode(7, 20);
		myList.printAll();
		
		System.out.println("------------------------------");
		
		myList.deleteNode(20);
		myList.printAll();
		
		
	}

}
