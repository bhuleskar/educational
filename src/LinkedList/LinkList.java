package LinkedList;

import java.util.ArrayList;
import java.util.List;


//class LinkedList {
//
//	public Node head;
//
//	public LinkedList() {
//		head = null;
//	}
//
//	public void addToEnd(int data) {
//		Node current = head;
//
//		while (current.next != null) {
//			current = current.next;
//		}
//		Node newNode = new Node(data);
//		newNode.next = current.next;
//		current.next = newNode;
//	}
//
//	public void addFirst(int data) {
//		Node newNode = new Node(data);
//		newNode.next = head;
//		head = newNode;
//	}
//	
//	public void insertNth(int data,int index){
//		int count =1;
//		Node cur = head;
//		if(index ==1){
//			addFirst(data);
//		}else{
//			while(count<index-1){
//				if(cur==null){
//					return;
//				}
//				count++;
//				cur=cur.next;
//			}
//			if(cur==null || cur.next ==null){
//				return;
//			}
//			Node newNode = new Node(data);
//			newNode.next=cur.next;
//			cur.next=newNode;
//			
//		}
//	}
//
//	public void deleteIndex(int index) {
//		Node curr = head;
//		int count = 1;
//		if (index == 1) {
//			Node temp;
//			temp = curr.next;
//			curr = null;
//			head = curr = temp;
//		} else {
//			while (count < index - 1) {
//				if (curr == null) {
//					return;
//				}
//				count++;
//				curr = curr.next;
//			}
//			if (curr == null || curr.next == null) {
//				return;
//			}
//			Node temp = curr.next;
//			curr.next = temp.next;
//			temp = null;
//		}
//	}
//
//	public void deleteData(int data) {
//		Node curr = head;
//		if (data == curr.data) {
//			Node temp;
//			temp = curr.next;
//			curr = null;
//			head = curr = temp;
//		}
//		while (curr.next != null) {
//			if (curr.next.data == data) {
//				Node temp = curr.next;
//				curr.next = temp.next;
//				temp = null;
//			} else {
//				curr = curr.next;
//			}
//		}
//	}
//
//}
//
//class Node {
//	int data;
//	Node next;
//
//	public Node(int data) {
//		this.data = data;
//	}
//}
//
//public class MainClass {
//	public static void main(String args[]) {
//		LinkedList list = new LinkedList();
//		list.addFirst(3);
//		list.addFirst(1);
//		list.addFirst(2);
//		list.addToEnd(4);
//		list.addToEnd(2);
//		list.addToEnd(4);
//		list.addToEnd(2);
//		list.insertNth(8, 5);
//		// list.deleteIndex(1);
//		// list.deleteData(2);
//		Node curr = list.head;
//		while (curr != null) {
//			System.out.println(curr.data);
//			curr = curr.next;
//		}
//
//	}
//}


class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}
}

public class LinkList {
	public Node first;

	public LinkList() {
		first = null;
	}
	
    public static void main(String[] args) {
        LinkList theList = new LinkList();

        theList.insertFirst(5);
        theList.insertFirst(4);
        theList.insertFirst(2);
        theList.insertFirst(1);
       // theList.appendToTail(3);
        theList.insertMiddle(3);
        theList.insertFirst(5);
        theList.insertFirst(3);
        //theList.reverseList();
        theList.deleteDuplicate();
        //theList.deleteIndex(theList.first, 3);
        //theList.deleteNode(theList.first, 3);
        Node current = theList.first;
        while (current != null) {
            // Node aLink = theList.deleteFirst();
            // System.out.print("Deleted " + aLink);
            System.out.println("Node==" + current.data);
            current = current.next;
        }
        theList.lengthOfLinkedList();
    }

	public boolean isEmpty() {
		return (first == null);
	}

	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = first;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public void lengthOfLinkedList(){
        int count=0;
        
        Node temp = first;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        System.out.println(count);
    }

	public void insertMiddle(int index){
		Node current = first;
		int count =1;
		while(count<index-1){
			current = current.next;
			count++;
		}
		Node newInsert = new Node(3);
		newInsert.next =current.next;
		current.next=newInsert;
	}
	
	public void insertFirst(int id) {
		Node newLink = new Node(id);
		newLink.next = first;
		first = newLink;
	}

	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
		return temp;
	}
	
	public void deleteNode(Node head, int d) {
		Node n = first;
		while (first.data == d) {
			first= first.next; /* moved head */
		}
		
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				//return head; /* head didnÕt change */
			}else
			n = n.next;
			
		}
		//return n;
	}
	
	public void deleteIndex(Node head,int index) {
		int count =1;
		Node cur = head;
		while(count<index-1){
			cur = cur.next;
			count++;
		}
		Node tmp = cur.next;
		cur.next=tmp.next;
	}
	
	public void reverseList(){
	    Node temp = null;
	    Node cur  = first;
	    Node next=null;
	    while(cur!=null){
	        next = cur.next;
	        cur.next= temp;
	        temp = cur;
	        cur=next;
	    }
	    cur= first= temp;
	}
	
	public void deleteDuplicate(){
	    Node current = first;
	    List lst = new ArrayList();
	    if(current!=null){
	        lst.add(current.data);
	    }
	    while (current!=null && current.next!=null){
	        if(lst.contains(current.next.data)){
	            Node temp = current.next;
	            current.next= temp.next;
	        } else{
	            lst.add(current.next.data);
	        }
	        current = current.next;
	    }
	}
	
}
