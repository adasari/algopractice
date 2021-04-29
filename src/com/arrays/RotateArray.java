package com.arrays;

public class RotateArray {

	// reverse whole array
	// reverse 0-k
	// reverse k-n
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		rotate(a, 2);
	}

	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		print(nums);
		reverse(nums, 0, k - 1);
		print(nums);
		reverse(nums, k, nums.length - 1);
		print(nums);

	}

	private static void reverse(int[] nums, int start, int end) {
		int temp = 0;
		while (start < end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			
			start++;
			end--;
		}
	}

	public static void print(int[] nums) {
		for (int n : nums) {
			System.out.printf("%d ", n);
		}

		System.out.println();
	}
}
