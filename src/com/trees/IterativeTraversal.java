package com.trees;

import java.util.Stack;

/*
 * 1. 
 * 
 */

public class IterativeTraversal {
	
	public static void main(String[] args) {
		Node root = Node.from(10)
				.left(Node.from(4)
						.left(Node.from(3))
						.right(Node.from(6)
								.left(Node.from(5))))
				.right(Node.from(15));
		
		IterativeTraversal iterative = new IterativeTraversal();
//		iterative.inOrder(root);
		iterative.preOrder(root);
		
		
	}
	
	
	private void inOrder(Node node) {
		Stack<Node> stack = new Stack<>();
		while(true) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			node = stack.pop();
			System.out.println(node.getData());
			node = node.getRight();
			
		}
	}
	
	
	private void preOrder(Node node) {
		Stack<Node> stack = new Stack<>();
		while(true) {
			while (node != null) {
				System.out.println(node.getData());
				stack.push(node);
				node = node.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			node = stack.pop();
			
			node = node.getRight();
			
		}
	}
	
	private void postOrder(Node node) {
		Stack<Node> stack = new Stack<>();
		while(true) {
			while (node != null) {
				System.out.println(node.getData());
				stack.push(node);
				node = node.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			node = stack.pop();
			
			node = node.getRight();
			
		}
	}

}
