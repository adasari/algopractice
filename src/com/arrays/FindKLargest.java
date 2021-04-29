package com.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindKLargest {
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < a.size(); i++) {
			if(stack.isEmpty()) {
				stack.add(a.get(i));
				continue;
			}
			
			while (!stack.isEmpty() && a.get(i) > stack.peek()) {
				
			}
		}
	}

}
