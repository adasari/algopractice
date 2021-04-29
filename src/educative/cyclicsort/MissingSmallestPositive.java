package educative.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class MissingSmallestPositive {
	private int findNumbers(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int actualIndex = nums[i] - 1;
			if (actualIndex >= 0 && actualIndex < nums.length && nums[i] != nums[actualIndex]) {
				swap(nums, i, actualIndex);
			}else {
				i++;
			}
		}
		
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i+1) {
				return i+1;
			}
		}
		
		
		return nums.length + 1;
	}

	private void swap(int[] nums, int i, int actualIndex) {
		int temp = nums[i];
		nums[i] = nums[actualIndex];
		nums[actualIndex] = temp;
	}

	public static void main(String[] args) {
		System.out.println(new MissingSmallestPositive().findNumbers(new int[] {-3, 1, 5, 4, 2}));
		System.out.println(new MissingSmallestPositive().findNumbers(new int[] {3, -2, 0, 1, 2}));
		System.out.println(new MissingSmallestPositive().findNumbers(new int[] {3, 2, 5, 1}));
	}
}
