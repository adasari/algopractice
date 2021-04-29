package educative.intervals;

public class MissingNumber {
	
	private int missingNumber(int[] nums) {
		int i = 0;
		
		while (i < nums.length) {
			int actualIndex = nums[i] - 1;
			if (nums[i] != nums[actualIndex]) {
				swap(nums, i, actualIndex);
			}else {
				i++;
			}
		}
		
		for (int j = 0;  j< nums.length; i++) {
			if (nums[j] != j+1) {
				return j+1;
			}
		}
		
		return -1;
	}

	private void swap(int[] nums, int i, int actualIndex) {
		// TODO Auto-generated method stub
		
	}

}
