package blind75;

import java.util.Arrays;

// 217. Contains Duplicate
public class ContainsDuplicate {
	public static void main(String[] args) {
		System.out.println(new ContainsDuplicate().containsDuplicate(new int[] {1,2,3,1}));
		System.out.println(new ContainsDuplicate().containsDuplicate(new int[] {1,2,3,4}));
		System.out.println(new ContainsDuplicate().containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
	}

	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <=1) return false;
		
		Arrays.sort(nums);
		
		int prev = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (prev == nums[i]) {
				return true;
			}
			
			prev = nums[i];
		}
		
		return false;
	}

}
