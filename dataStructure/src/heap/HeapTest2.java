package heap;

public class HeapTest2 {

	public static void main(String[] args) {

		Heap2 heapTest = new Heap2();
		heapTest.insertHeap(15);
		heapTest.insertHeap(10);
		heapTest.insertHeap(8);
		heapTest.insertHeap(5);
		heapTest.insertHeap(4);
		heapTest.insertHeap(20);
		
		System.out.println(heapTest.heapArray);
		System.out.println(heapTest.pop());
		System.out.println(heapTest.heapArray);
	}

}
