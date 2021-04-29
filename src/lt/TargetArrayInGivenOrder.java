package lt;

import java.util.Arrays;

/*
 * 
 * 1389. Create Target Array in the Given Order
Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

 

Example 1:

Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
 */

public class TargetArrayInGivenOrder {

	public static void main(String[] args) {
//		int[] nums = {0,1,2,3,4};
//		int[] index = {0,1,2,2,1};
		
		int[] nums = {1,2,3,4,0};
		int[] index = {0,1,2,3,0};
		new TargetArrayInGivenOrder().createTargetArray(nums, index);
	}
	
	public int[] createTargetArray(int[] nums, int[] index) {
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);

		for (int i = 0; i < index.length; i++) {
			int num = nums[i];
			int idx = index[i];
			if (result[idx] == -1) {
				result[idx] = num;
			} else {
				// right shift elements from idx.
				System.arraycopy(result, idx, result, idx + 1, nums.length - (idx + 1));
				result[idx] = num;
				// print(result);
			}
		}

		// print(result);
		return result;
	}
	
	private void print(int[] a) {
		for (int i : a) {
			System.out.printf("%d ", i);
		}
		
		System.out.println();
	}

}
