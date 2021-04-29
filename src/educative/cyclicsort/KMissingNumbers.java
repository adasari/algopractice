package educative.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class KMissingNumbers {
	
	private List<Integer> findNumbers(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		List<Integer> extraNumbers = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			int actualIndex = nums[i] - 1;
			if (actualIndex > 0 && actualIndex < nums.length && nums[i] != nums[actualIndex]) {
				swap(nums, i, actualIndex);
			}else {
				i++;
			}
		}
		
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i+1) {
				result.add(i+1);
				extraNumbers.add(nums[i]);
			}
		}
		
		i = 1;
		while (result.size() < k) {
			int e = i+ nums.length;
			if (!extraNumbers.contains(e)) {
				result.add(e);
			}
		}
		
		return result;
	}

	private void swap(int[] nums, int i, int actualIndex) {
		int temp = nums[i];
		nums[i] = nums[actualIndex];
		nums[actualIndex] = temp;
	}

	public static void main(String[] args) {
	}

}
