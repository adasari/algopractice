package educative.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class CorruptPair {
	
	public static void main(String[] args) {
		new CorruptPair().findNumbers(new int[] {3, 1, 2, 5, 2});
		new CorruptPair().findNumbers(new int[] {3, 1, 2, 3, 6, 4});
	}
	
	private int[] findNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		
		int i = 0;
		while (i < nums.length) {
			int actualIndex = nums[i] - 1;
			if (actualIndex < nums.length && nums[i] != nums[actualIndex]) {
				swap(nums, i, actualIndex);
			}else {
				i++;
			}
		}
		
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i+1) {
				result.add(nums[i]);
				result.add(i+1);
				System.out.println(nums[i]+ " "+ (i+1));
				return new int[] {nums[i], i+1};
			}
		}
		
		System.out.println("-1, -1");
		return new int[] {-1, -1};
	}

	private void swap(int[] nums, int i, int actualIndex) {
		int temp = nums[i];
		nums[i] = nums[actualIndex];
		nums[actualIndex] = temp;
	}

}
