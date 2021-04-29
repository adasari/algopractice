package com.trees;

public class Node {
	
	private int data;
	
	private Node left;
	
	private Node right;
	
	public Node(int data)  {
		this.data = data;
	}
	
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public static Node from(int data) {
		return new Node(data); 
	}
	
	public Node left(Node left) {
		this.left = left;
		return this;
	}
	
	public Node right(Node right) {
		this.right = right;
		return this;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
}
