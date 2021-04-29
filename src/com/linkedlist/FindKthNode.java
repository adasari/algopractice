package com.linkedlist;

public class FindKthNode {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2, n1);
		Node n3 = new Node(3, n2);
		Node n4 = new Node(4, n3);
		Node n5 = new Node(5, n4);
		Node n6 = new Node(6, n5);
		
		// recursive approach.
		/*
		Node root = n6;
		Node f = recursive(root, 1, 6);
		System.out.println(f.getData());
		*/
		
		
		Node current =  n6;
		int count = 1;
		//while (current != null && count <=)
		
	}
	
	

	
}
