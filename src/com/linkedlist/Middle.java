package com.linkedlist;

public class Middle {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2, n1);
		Node n3 = new Node(3, n2);
		Node n4 = new Node(4, n3);
		Node n5 = new Node(5, n4);
		Node n6 = new Node(6, n5);
		
		Node slow = n5;
		Node fast = n5;
		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		System.out.println("middle - "+ slow.getData());
		
	}

}
