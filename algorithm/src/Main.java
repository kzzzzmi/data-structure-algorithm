<<<<<<< HEAD
public class Main {

	Node head;

	public class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.data + "";
		}
	}

	public Integer deleteData(int data) {
		if (this.head == null) {
			return null;
		} else if(head.data == data && head.left == null && head.right == null) {
			this.head = null;
			return data;
		}

		Node node = this.head;
		Node parentNode = this.head;
		boolean isSearched = false;

		while (node != null) {
			if (data == node.data) {
				isSearched = true;
				break;
			} else if (data < node.data) {
				parentNode = node;
				node = node.left;
			} else {
				parentNode = node;
				node = node.right;
			}
		}

		if (!isSearched) {
			return null;
		}

		if (node.left == null && node.right == null) {
			if (data < parentNode.data) {
				parentNode.left = null;
				return data;
			} else {
				parentNode.right = null;
				return data;
			}
		} else if (node.left != null && node.right != null) {
			Node searchParentNode = node;
			Node searchNode = node.right;
			
			if(searchNode.left == null) {
				searchParentNode.right = null;
			} else {
				while(searchNode.left != null) {
					searchParentNode = searchNode;
					searchNode = searchNode.left;
				}
			}
			
			if(searchNode.right != null) {
				searchParentNode.left = searchNode.right;
			} else {
				searchParentNode.left = null;
			}
			
			searchNode.left = node.left;
			searchNode.right = node.right;
			
			if(data < parentNode.data) {
				parentNode.left = searchNode;
			} else if(data > parentNode.data){
				parentNode.right = searchNode;
			} else {
				this.head = searchNode;
			}
		} else {
			if(node.right == null) {
				if(data < parentNode.data) {
					parentNode.left = node.left;
					node = null;
				} else if(data > parentNode.data){
					parentNode.right = node.left;
					node = null;
				} else {
					this.head = node.left;
				}
			} else {
				if(data < parentNode.data) {
					parentNode.left = node.right;
					node = null;
				} else if(data > parentNode.data) {
					parentNode.right = node.right;
					node = null;
				} else {
					this.head = node.right;
				}
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Stack<Integer> stack = new Stack<Integer>();
		int[] inputs = new int[N];
		int[] count = new int[1000001];
		int[] answer = new int[N];

		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
			count[inputs[i]]++;
		}

		stack.push(0);

		for (int i = 1; i < N; i++) {
			while (!stack.empty() && count[inputs[stack.peek()]] < count[inputs[i]]) {
				answer[stack.pop()] = inputs[i];
>>>>>>> b782af2213c6bbb5c28a0921d00325ba1d7c24aa
			}

			stack.push(i);
		}
<<<<<<< HEAD
		return data;
	}

	public boolean searchData(int data) {
		if (this.head == null) {
			return false;
		}

		Node node = this.head;

		while (node != null) {
			if (data == node.data) {
				return true;
			} else if (data < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return false;
	}

	public void addData(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node node = head;
		Node parentNode = head;

		while (node != null) {
			if (data < node.data) {
				parentNode = node;
				node = node.left;
			} else {
				parentNode = node;
				node = node.right;
			}
		}

		if (data < parentNode.data) {
			parentNode.left = new Node(data);
		} else {
			parentNode.right = new Node(data);
		}
	}

	public static void main(String[] args) {
		Main bst = new Main();
		bst.addData(10);
		bst.addData(8);

		System.out.println(bst.head);
		System.out.println(bst.head.left);
		
		System.out.println(bst.deleteData(10));
		System.out.println();
		
		System.out.println(bst.head);
=======

		while (!stack.empty()) {
			answer[stack.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(' ');
		}

		System.out.println(sb);
>>>>>>> b782af2213c6bbb5c28a0921d00325ba1d7c24aa
	}

}
