package lt;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReplaceWithGreater {
	public static void main(String[] args) {
		new ReplaceWithGreater().replaceElements(new int[] {17,18,5,4,6,1});
		//new ReplaceWithGreater().replaceElements(new int[] {17,18,5,4,6,1});
	}
	
	public int[] replaceElements(int[] arr) {
		
		int n = arr.length;
		int[] result = new int[n];
		
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> nextGreater = new HashMap<>();
		// find next greater element.
		for (Integer val : arr) {
			while (!stack.isEmpty() && stack.peek() <= val) {
				nextGreater.put(stack.pop(), val);
			}
			
			stack.push(val);
		}
		
		// fill gaps in the greatest map and evaluate result[i]
		// or just iterate from end so that next element's greater element is already present if current dont have any greater element.
		
		result[n-1] = -1;
		for (int i = n-2; i >= 0; i--) {
			// when next element dont have greater element i.e -1, 
			// use next element itself as greater element for current element.
			result[i] = nextGreater.getOrDefault(arr[i],  (result[i+1] == -1) ? arr[i+1]: result[i+1]);
		}
		
		print(result);
		return result;
	}
	
	private void print(int[] p) {
		for (int i : p) {
			System.out.printf("%d ", i);
		}
		
		System.out.println();
	}

}
