package queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(5);
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
	
	}
}
