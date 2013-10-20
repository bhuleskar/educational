/*-
 * This computer program is the confidential information and proprietary trade
 * secret of Cisco Systems, Inc. Possessions and use of this program must
 * conform strictly to the license agreement between the user and Cisco Systems,
 * Inc., and receipt or possession does not convey any rights to divulge,
 * reproduce, or allow others to use this program without specific written
 * authorization of Cisco Systems, Inc.
 * 
 * Copyright 2011-2013 Cisco Systems, Inc. All rights reserved.
 * 
 * Created on Oct 20, 2013
 */
package LinkedList;

//https://docs.google.com/file/d/0B1IAWg8KZLEEOTZZNksyMG84UUk/edit?usp=sharing

/**
 * List is a circular doubly-linked list. It employs a sentinel (dummy) node at the head of the list.
 * 
 * List invariants: 1) head != null. 
 * 2) For any Node x in a List, x.next != null.
 * 3) For any Node x in a List, x.prev != null.
 * 4) For any Node x in a List, if x.next == y, then y.prev == x. 
 * 5) For any Node x in a List, if x.prev == y, then y.next == x.
 * 6) size is the number of Nodes in the List, NOT COUNTING the sentinel,
 */

public class Doubly {

    public static void main(String[] args) {
        Doubly myList = new Doubly();

        myList.insertFront(" = Four!");
        myList.insertFront(2.00);
        myList.insertFront('+');
        myList.insertFront("TWO");

        System.out.println(myList.toString()); //OUTPUT: [  TWO  +  2.0   = Four!  ]
    }

    /**
     * A Node object is a node in a List (doubly-linked circular list).
     */
    private class Node<T> {

        Node next;
        Node prev;

        Object obj;

        Node(Object obj) {
            this.obj = obj;

        }

    }

    protected Node<Integer> head; //References the sentinel node
    protected int size;

    public Doubly() {

        Node head = new Node(-1);
        head.next = head;
        head.prev = head;

    }

    public <T> void insertFront(T item) {

        Node n = new Node(item);

        if (head.next == head) {
            head.next = n;
            n.prev = head;
            head.prev = n;
            n.next = head;
        } else {
            Node temp = head.next;
            temp.prev = n;
            n.next = head.next;
            head.next = n;
            n.prev = head;
        }
    }

}
