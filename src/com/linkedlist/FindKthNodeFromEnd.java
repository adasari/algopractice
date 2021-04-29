package com.linkedlist;

public class FindKthNodeFromEnd {
	
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
		
		int position = 6;
		Node current = n6;
		while (current != null && position > 1) {
			position--;
			current = current.getNext();
		}
		
		if (position > 0) {
			System.out.println("not exists");
		}else {
			System.out.println(current.getData());
		}
		
		
	}
	
	private static Node recursive(Node current, int position, int k) {
		if (current == null) {
			return null;
		} else if (position == k) {
			return current;
		}
		
		return recursive(current.getNext(), ++position, k);
		
	}

	private static Node recursive(Node current, int k) {
		if (current == null) {
			return null;
		} else if (k == 1) {
			return current;
		}
		
		return recursive(current.getNext(), k-1);
		
	}
}
