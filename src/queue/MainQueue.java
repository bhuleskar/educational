package queue;

public class MainQueue {


	public static void main(String[] args){
		QueueImp q = new QueueImp();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue());
		q.enqueue(5);
		Node cur = q.head;
		while(cur!=null){
			System.out.println(cur.data);
			cur = cur.next;
		}
		
	}
}

class QueueImp{
	Node head;
	Node tail;
	
	public QueueImp(){
		head=null;
		tail=null;
	}
	
	public void enqueue(int data) {
		if (head == null) {
			Node n = new Node(data);
			tail = head= n;
		} else {
			Node n = new Node(data);
			tail=tail.next = n;
		}
	}
	
	public int dequeue(){
		int val = head.data;
		head = head.next;
		return val;
	}
	
}

class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
	}
}
