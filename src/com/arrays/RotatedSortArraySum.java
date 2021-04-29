package com.arrays;

// https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
public class RotatedSortArraySum {
	
	public static void main(String[] args) {
		int[] nums = {11, 15, 6, 8, 9, 10};
		int sum = 5;
		
		int i = 0;
		for (i=0; i < nums.length; i++) {
			if (nums[i] > nums[i+1]) {
				break;
			}
		}
		
		int lower = (i+1)%nums.length;
		int higher = i;
		
		while(lower != higher) {
			int s = nums[lower] + nums[higher];
			if (s == sum) {
				System.out.printf("sum %d is present: %d, %d", sum, nums[lower], nums[higher]);
				break;
			}else if (s < sum) {
				lower = (lower + 1) %nums.length;
			}else {
				higher = (higher + nums.length -1) %nums.length;
			}
		}
	}

}
