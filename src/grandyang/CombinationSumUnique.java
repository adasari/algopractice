package grandyang;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumUnique {

	public static void main(String[] args) {
		//new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);
		new CombinationSumUnique().combinationSum(new int[] {2,3,5}, 8);
	}
	
	private List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		// TODO: not sorted ? sort it.
		List<Integer> currentSum = new ArrayList<>();
		
		combinationSum(result, currentSum, nums, 0, target);
		return result;
	}
	
	
	private void combinationSum(List<List<Integer>> result, List<Integer> currentSum, int[] nums, int start, int target) {
		if (target == 0) {
			result.add(new ArrayList<>(currentSum));
			return;
		}
		
		for (int i = start; i < nums.length;i++) {
			if (i > start && nums[i] == nums[i-1]) continue;
			if (nums[i] > target) {
				break;
			}
			
			currentSum.add(nums[i]);
			combinationSum(result, currentSum, nums, i, target-nums[i]);
			currentSum.remove(currentSum.size()-1);
		}
	}
	
}
