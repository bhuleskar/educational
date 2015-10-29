package stack;

public class StackLL {

	public static void main(String[] args) {
		HelperStack help = new HelperStack();
		help.push(1);
		help.push(2);
		help.push(3);
		System.out.println(help.pop());
		System.out.println(help.pop());
		System.out.println(help.pop());
		System.out.println(help.pop());
	}
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

class HelperStack {
	Node top;
	Node front;

	public void push(int data) {
		if (top == null) {
			Node n = new Node(data);
			n.next = top;
			top = n;
		} else {
			Node n = new Node(data);
			n.next = top;
			top = n;
		}
	}

	public int pop() {
		if (top == null) {
			System.out.println("Nothing to return");
			return -1;
		} else {

			int val = top.data;
			top = top.next;
			return val;
		}
	}
}
