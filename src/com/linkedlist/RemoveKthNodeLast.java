package com.linkedlist;

public class RemoveKthNodeLast {
	
	public static void main(String[] args) {
		
		Node root = Node.From(1)
				.Next(Node.From(2)
						.Next(Node.From(3)
								.Next(Node.From(4)
										.Next(Node.From(5)
												   .Next(Node.From(6))
											  )
									   )
							 )
					  );
		
		
		
		int k = 2;
		Node fast = root;
		Node slow = root;
		
		for(int i =0 ; i <k; i++) {
			slow = slow.getNext();
		}
		System.out.println(slow.getData());
		
		while (slow.getNext() != null) {
			fast = fast.getNext();
			slow = slow.getNext();
		}
		
		System.out.println(fast.getData());
		
		fast.Next(fast.getNext().getNext());
		
		
		//for 
		
		
		
	}

}
