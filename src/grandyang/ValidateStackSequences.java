package grandyang;

import java.util.Stack;

public class ValidateStackSequences {
	
	/*
	 
	 946. Validate Stack Sequences
	 
	 Initialize am empty stack,
	iterate and push elements from pushed one by one.
	Each time, we'll try to pop the elements from as many as possibile popped.
	In the end, we we'll check if stack is empty.
	
	Time O(N)
	Space O(N)
	 
	 
	 */
	private boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		
		int i = 0;
		for (Integer ele : pushed) {
			stack.push(ele);
			
			while (!stack.isEmpty() && stack.peek() == popped[i]) {
				stack.pop();
				i++;
			}
		}
		
		return stack.size() == 0;
	}

}
