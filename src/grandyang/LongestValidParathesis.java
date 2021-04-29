package grandyang;

import java.util.Stack;

public class LongestValidParathesis {

	public static void main(String[] args) {
		new LongestValidParathesis().longestValidParentheses(")))))");
	}

	private int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int top = stack.peek();
			if (top != -1 && s.charAt(top) == '(' && c == ')') {
				stack.pop();
				result = Math.max(i - stack.peek(), result);
			} else {
				stack.push(i);
			}
		}

		System.out.println(result);
		return result;
	}

}
