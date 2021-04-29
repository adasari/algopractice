package com.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node root = Node.From(1)
				.Next(Node.From(2)
						.Next(Node.From(3)
								.Next(Node.From(4))
							 )
					  );
	}
	
	
	public static Node reverseListIterative(Node node){
		Node previous = null;
		Node current = node;
		Node next = null;
		
		while (current != null) {
			next = current.getNext();
			current.Next(previous);
			previous = current;
			current = next;
		}
		return previous;
		
	}
	
	public static Node reverse(Node node) {
		if (node.getNext() == null) {
			
		}
		return node;
	}
}





