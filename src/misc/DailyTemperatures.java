package misc;

import java.util.Stack;

public class DailyTemperatures {
	
	public static void main(String[] args) {
		new DailyTemperatures().dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
	}

	public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
				result[stack.peek()] = i - stack.peek();
				stack.pop();
				
			}
			
			stack.push(i);
		}
		
		return result;
	}
}
