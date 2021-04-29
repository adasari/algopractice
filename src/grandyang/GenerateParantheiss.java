package grandyang;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheiss {
	
	public static void main(String[] args) {
		new GenerateParantheiss().generate(3);
	}
	
	private List<String> generate(int nums) {
		List<String> result = new ArrayList<>();
		backtrack(result, "", nums, 0, 0);
		
		return result;
	}
	
	private void backtrack(List<String> result, String current, int nums, int open, int close) {
		if (current.length() == nums * 2) {
			System.out.println(current);
			result.add(current);
			return;
		}
		
		if (open < nums) backtrack(result, current + "(", nums, open + 1, close);
		if (close < open) backtrack(result, current + ")", nums, open, close + 1);
	}

}
