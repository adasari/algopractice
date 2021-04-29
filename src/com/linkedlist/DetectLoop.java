package com.linkedlist;

public class DetectLoop {

	public static void main(String[] args) {
		Node n6 = new Node(6);
		Node n5 = new Node(5, n6);
		Node n4 = new Node(4, n5);
		Node n3 = new Node(3, n4);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(1, n2);

		n6.Next(n3);

		LinkedList l = new LinkedList();
		l.push(20);
		l.push(4);
		l.push(15);
		l.push(10);
		l.push(1);

		l.getHead().getNext().getNext().getNext().Next(l.getHead()); 
		
		Node slow = l.getHead();;
		Node fast = l.getHead();;

		boolean loop = false;
		while (slow != null && fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if (slow == fast) {
				loop = true;
				break;
			}
		}

		System.out.println("loop is " + loop + " " + slow.getData());
	}

}
