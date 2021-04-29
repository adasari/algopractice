package july;

import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		List<String> code = Arrays.asList("banana", "banana");
		List<String> shopping = Arrays.asList("apple", "orange", "banana");
		
		System.out.println(new Solution().matched(code, shopping, 0));
	}
	
	private int matched(List<String> code, List<String> shoppingCart, int index) {
		int cIndex = 0;
		
		while (index < shoppingCart.size()) {
			String s = shoppingCart.get(index);
			String c = code.get(cIndex);
			if (c.equals("anything")  || c.equals(s)) {
				cIndex++;
				index++;
			}else if (cIndex > 0){
				cIndex = 0;
			}else {
				index++;
			}
			
			if (cIndex == code.size()) {
				return index-code.size();
			}
		}
		
		/*
		for (int i = index; i < shoppingCart.size(); i++) {
			String s = shoppingCart.get(i);
			String c = code.get(cIndex);
			
			if (c.equals("anything") || c.equals(s)) {
				cIndex++;
			}else {
				cIndex = 0;
			}
			
			if (cIndex == code.size()) {
				System.out.println("matchd");
				return i-code.size()+1;
			}
		}
		
		*/
		return -1;
	}

}
