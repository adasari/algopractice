package com.arrays;

/*You are given an array of integers in an arbitrary order. Return whether or not it is possible to make the array non-decreasing by modifying at most 1 element to any value.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example:

[13, 4, 7] should return true, since we can modify 13 to any value 4 or less, to make it non-decreasing.

[13, 4, 1] however, should return false, since there is no way to modify just one element to make the array non-decreasing.
*/

public class NonDecresingArraySingleModification {
	
	public static void main(String[] args) {
		int[] nums = new int[] {3,4,2,3};
		System.out.println(check(nums));
		
	}
	
	private static boolean check(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i+1]) {
				count++;
			}
		}
		
		if (count > 1 ) {
			return false;
		}
		
		return true;
	}

}
