package blind75;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		new TwoSum().twoSum(new int[] {2,7,11,15}, 9);
		new TwoSum().twoSum(new int[] {3,2,4}, 6);
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				System.out.println(i + " " + map.get(target - nums[i]));
				return new int[] {i, map.get(target - nums[i])};
			}else {
				map.put(nums[i], i);
			}
		}
		
		return null;
	}

}
