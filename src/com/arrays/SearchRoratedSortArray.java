package com.arrays;

// https://www.youtube.com/watch?v=QdVrY3stDD4
public class SearchRoratedSortArray {

	public static void main(String[] args) {
//		int index = search(new int[]{11, 15, 6, 8, 9, 10}, 10);
		int index = search(new int[]{4,5,6,7,0,1,2}, 3);
		System.out.printf("%d", index);
		
	}
	
	// find pivot
	// search pivot left or right 
	private static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		if (nums.length == 1) {
			return nums[0];
		}
		
		int left  = 0;
		int right  = nums.length -1;
		
		/*
		 for (i = 0; i < n - 1; i++) 
	        if (nums[i] > nums[i + 1]) 
	            break;
		 */
		// find pivot. finding pivot can be linear or like below		
		while (left < right) {
			int midpoint = left + (right-left)/2;
			if (nums[midpoint] > nums[right]) {
				left = midpoint + 1;
			}else {
				right = midpoint;
			}
		}
		
		int start = left;
		left = 0;
		right = nums.length -1;
		
		// indentify the start and end for binary search
		if (target >= nums[start] && target <= nums[right]) {
			left = start;
		}else {
			right = start;
		}
		
		// binary search the start and end
		while (left <= right) {
			int midpoint = left + (right -left)/2;
			if (nums[midpoint] == target) {
				return midpoint; 
			}
			
			if (nums[midpoint] < target) {
				left = midpoint + 1;
			}else {
				right = midpoint - 1;
			}
		}
		
		return -1;
	}
}
