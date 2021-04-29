package misc;

import java.util.Stack;

public class MinParathesisRemoved {
	/*
	private int minRemoved(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (Character c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}
		
		System.out.println(stack.size());
		return stack.size();
	}
	
	*/
	
	private int minRemoved(String s) {
		int opened = 0;
		int invalid = 0;
		
		for (Character c : s.toCharArray()) {
			if (c == '(') {
				++opened;
			} else {
				if (opened > 0) {
					--opened;
				}else {
					++invalid;
				}
			}
		}
		
		System.out.println(invalid + opened);
		return invalid + opened;
	}
	
	public static void main(String[] args) {
		new MinParathesisRemoved().minRemoved("()())()");
		new MinParathesisRemoved().minRemoved(")(");
	}

}
