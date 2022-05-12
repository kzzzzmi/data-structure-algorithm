package linkedList;

public class MainTest2 {

	public static void main(String[] args) {

		DoubleLinkedList<Integer> myList = new DoubleLinkedList<>();
		myList.insertToFront(1, 6);
		myList.addNode(1);
		myList.addNode(2);
		myList.addNode(3);
		myList.addNode(4);
		myList.addNode(5);	
		myList.printAll();
		System.out.println("-----------------------");
		
		System.out.println(myList.searchFromHead(1));
		System.out.println(myList.searchFromTail(6));
		System.out.println("-----------------------");
		
		
		myList.insertToFront(6, 7);
		myList.insertToFront(7, 8);
		myList.insertToFront(5, 9);
		myList.printAll();
	}

}
