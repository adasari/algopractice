package com.linkedlist;

public class Node {
	
	private int data;
	private Node next;
	
	
	
	
	public static Node From(int data) {
		return new Node(data);
	}
	
	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public Node Next(Node next) {
		this.next = next;
		return this;
	}

}
