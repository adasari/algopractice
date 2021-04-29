package lt;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FinalPrices {

	public static void main(String[] args) {
		new FinalPrices().finalPrices(new int[] { 8, 4, 6, 2, 3 });
		new FinalPrices().finalPrices(new int[] { 1,2,3,4,5 });
	}

	// build next greater element map
	public int[] finalPrices(int[] prices) {
		int[] result = new int[prices.length];
		int n = prices.length;

		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> nextLowest = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int val = prices[i];
			while (!stack.isEmpty() && stack.peek() > val) {
				nextLowest.put(stack.pop(), val);
			}

			stack.push(val);
		}

		for (int i = 0; i < n; i++) {
			int price = prices[i];
			Integer lowest = nextLowest.getOrDefault(price, 0);

			result[i] = prices[i] - lowest;
		}

		//print(result);
		return result;
	}

	private void print(int[] p) {
		for (int i : p) {
			System.out.printf("%d ", i);
		}
		
		System.out.println();
	}
}
