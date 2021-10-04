package heap;

public class HeapTest {

	public static void main(String[] args) {

		Heap heapTest = new Heap();
		heapTest.insert(15);
		heapTest.insert(10);
		heapTest.insert(8);
		heapTest.insert(5);
		heapTest.insert(4);
		heapTest.insert(20);
	
		System.out.println(heapTest.getHeapArray());	
		System.out.println(heapTest.pop());
		System.out.println(heapTest.getHeapArray());
	}

}
