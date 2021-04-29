package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/
public class Three3Sum {

	public static void main(String[] args) {
		List<List<Integer>> list = new Three3Sum().threeSum(new int[] {-1, 0, 1, 2, -1, -4});
		System.out.println(list.size());
		
		for (List<Integer> l : list) {
			for (Integer i : l) {
				System.out.printf("%d ", i);
			}
			
			System.out.println();
		}
	}
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		return sum(nums, 3, 0, 0, nums.length);
	}

	
	private List<List<Integer>> sum(int[] nums, int noOfElements, int sum, int start, int end) {
		List<List<Integer>> finalList = new ArrayList<>();
		
		if (noOfElements == 1) {
			// find sum element
			for (int i = start; i < end; i++) {
				if (nums[i] == sum) {
					// assume - element is found;
					List<Integer> list = new ArrayList<Integer>();
					list.add(sum);
					
					finalList.add(list);
				}
			}
			
			return finalList; 
		} 
		
		// as nums started -> can also optimize the sum for two elements from nums instead of 1 element scenario 
		
		for (int i = start; i < end; i++) {
			// nums is sorted, if previous element and current element same, lead to duplicate.
			//if (i > start && nums[i -1] == nums[i]) continue;
			
			int requied = sum - nums[i];
			List<List<Integer>> list = sum(nums, noOfElements - 1, requied, i+1, end);
			
			if (!list.isEmpty()) {
				for (List<Integer> l: list) {
					l.add(nums[i]);
					finalList.add(l);
				}
			}
		}
		
		return finalList;
	}
}
