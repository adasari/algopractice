package blind;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid( "()"));
		System.out.println(new ValidParentheses().isValid( "()[]{}"));
		System.out.println(new ValidParentheses().isValid( "(]"));
		System.out.println(new ValidParentheses().isValid( "([)]"));
		System.out.println(new ValidParentheses().isValid( "{[]}"));
	}
	
	public boolean isValid(String s) {
		Character p = null;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0 ; i < s.length(); i++) {
			Character c = s.charAt(i);
			switch (c) {
			case '{':
			case '[':
			case '(':
				stack.push(c);
				break;
			case '}':
				p = stack.pop();
				if (p != '{') {
					return false;
				}
				
				break;
			case ']':
				p = stack.pop();
				if (p != '[') {
					return false;
				}
				break;
			case ')':
				p = stack.pop();
				if (p != '(') {
					return false;
				}
				break;
			default:
				return false;
			}
		}
		return true;
	}
}
