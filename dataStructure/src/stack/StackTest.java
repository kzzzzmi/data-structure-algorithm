package stack;

public class StackTest {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(10);
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}

}