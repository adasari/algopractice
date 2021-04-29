package misc;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
	
	private static List<Integer> diffWaysToCompute;

	public static void main(String[] args) {
		diffWaysToCompute = new DifferentWaystoAddParentheses().diffWaysToCompute("2-1-1");
		print(diffWaysToCompute);
		diffWaysToCompute = new DifferentWaystoAddParentheses().diffWaysToCompute("2*3-4*5");
		print(diffWaysToCompute);
	}
	
	private static void print(List<Integer> list) {
		for (Integer i : list) {
			System.out.printf("%d ", i);
		}
		
		System.out.println();
	}

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();
		
		if (input == null || input.isBlank()) {
			result.add(0);
			return result;
		}
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				List<Integer> leftWays = diffWaysToCompute(input.substring(0, i));
				List<Integer> rightWays = diffWaysToCompute(input.substring(i+1));
				
				for (Integer left : leftWays) {
					for (Integer right : rightWays) {
						if (ch == '+') {
							result.add(left + right);
						}else if (ch == '-') {
							result.add(left - right);
						}else {
							result.add(left * right);
						}
					}
				}
			}
		}
		
		if (result.isEmpty()) {
			result.add(Integer.parseInt(input));
		}
		
		return result;
	}

}
