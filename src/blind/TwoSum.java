package blind;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		new TwoSum().twoSum(new int[] {2, 7, 11, 15}, 9);
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			map.put(num, i);
		}
		
		
		
		for (int i = 0; i < nums.length; i++) {
			int remaining = target - nums[i];
			if (map.containsKey(remaining)) {
				System.out.printf("%d %d", i,  map.get(remaining));
				return new int[]{i, map.get(remaining)};
			}
		}
		
		System.out.println("Not found");
		return null;

	}

	
	
}
