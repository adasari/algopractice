package com.linkedlist;

public class LenghOfLinkedList {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2, n1);
		Node n3 = new Node(3, n2);
		Node n4 = new Node(4, n3);
		Node n5 = new Node(5, n4);
		Node n6 = new Node(6, n5);
		
		// iterative approach.
		Node current = n6;
		int count = 0;
		while (current != null) {
			++count;
			current = current.getNext();
		}
		
		System.out.println(count);
		System.out.println(n6);
		
		// recursive approach
		current = n6;
		System.out.println(recursive(current));
		
	}
	
	public static int recursive(Node node) {
		if (node == null) {
			return 0;
		}
		
		return 1 + recursive(node.getNext());
	}
	
	
}
