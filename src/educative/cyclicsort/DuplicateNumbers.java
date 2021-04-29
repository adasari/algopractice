package educative.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class DuplicateNumbers {

	public static void main(String[] args) {
		new DuplicateNumbers().findNumbers(new int[]{3, 4, 4, 5, 5});
	}

	private List<Integer> findNumbers(int[] nums) {
		int i = 0;
		
		while ( i < nums.length) {
			int actualIndex = nums[i] - 1;
			if (nums[i] != nums[actualIndex]) {
				swap(nums, i, actualIndex);
			}else {
				i++;
			}
		}
		
		//print(nums);
		List<Integer> result = new ArrayList<Integer>();
		for (int j = 0; j < nums.length; i++) {
			if (nums[j] != j+1) {
				result.add(j+1);
			}
		}
		
		return result;
	}

	private void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d ", nums[i]);
		}
		
	}

	private void swap(int[] nums, int i, int actualIndex) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[actualIndex];
		nums[actualIndex] = temp;
	}

}
