package linkedList;

public class MainTest2 {

	public static void main(String[] args) {

		DoubleLinkedList<Integer> myList = new DoubleLinkedList<>();
		
		myList.addNode(1);
		myList.addNode(2);
		myList.addNode(3);
		myList.addNode(4);
		myList.addNode(5);	
		myList.printAll();
		System.out.println("-----------------------");
		
		myList.insertToFront(3, 2);
		myList.printAll();	
		System.out.println("------------------------");
		
		myList.insertToFront(6, 2);
		myList.insertToFront(1, 0);
		myList.printAll();	
		System.out.println("------------------------");
		
		myList.addNode(6);
		myList.printAll();	
		
	}

}
