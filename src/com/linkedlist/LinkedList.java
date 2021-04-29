package com.linkedlist;

public class LinkedList {
	
	private Node head;
	
	public void push(int val) {
		Node node = new Node(val, head);
		head = node;
	}

	public Node getHead() {
		return head;
	}
	
	
	public void addToTheLast(Node node) {
		 
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.getNext() != null)
				temp = temp.getNext();
 
			temp.Next(node);
		}
	}
	
}
