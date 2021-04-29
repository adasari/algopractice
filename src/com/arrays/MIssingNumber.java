package com.arrays;

import java.util.Arrays;

/*
Given a list of numbers, where every number shows up twice except for one number, find that one number.

Example:
Input: [4, 3, 2, 4, 1, 3, 2]
Output: 1

*/
public class MIssingNumber {
	
	public static void main(String[] args) {
		int[] nums = new int[] {4, 3, 2, 2 , 3, 4, 1};
		// sortApproach(nums);
		System.out.println(xorApproach(nums));
	}

	
	private static int sortApproach(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		int count = 1;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i-1] != nums[i]) {
				if (count < 2) {
					System.out.println(nums[i-1]);
					return nums[i-1];
				}
				count = 1;
			} else {
				count++;
			}
		}
		
		if (count < 2) {
			System.out.println(nums[nums.length-1]);
			return nums[nums.length-1];
		}
		
		return -1;
		
	}
	
	private static int xorApproach(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		
		int val = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			val = val ^ nums[i];
		}
		
		return val;
		
	}
	
}
