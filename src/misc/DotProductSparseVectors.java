package misc;

import java.util.HashMap;
import java.util.Map;

public class DotProductSparseVectors {
	
	public static void main(String[] args) {
		
		Map<Integer, Integer> first = new HashMap<>(); // got from sparse data structure
		Map<Integer, Integer> second  = new HashMap<>();
		
		int result = 0;
		if (first.isEmpty() || second.isEmpty()) {
			System.out.println(result);
		}
		
		if (first.size() >= second.size()) {
			result = dotProductSum(first, second);
		}else {
			result = dotProductSum(second, first);
		}
		
		System.out.println(result);
		
	}

	private static int dotProductSum(Map<Integer, Integer> first, Map<Integer, Integer>  second) {
		int sum = 0;
		for (Map.Entry<Integer, Integer> entry : first.entrySet()) {
			if (second.containsKey(entry.getKey())) {
				sum += entry.getValue() * second.get(entry.getKey());
			}
			
		}
		return sum;
	}
	
}
