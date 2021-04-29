package grandyang;

public class MissingPositiveNumber {
	
	public static void main(String[] args) {
		System.out.println(new MissingPositiveNumber().firstMissingPositive(new int[] {1,2,0}));
		System.out.println(new MissingPositiveNumber().firstMissingPositive(new int[] {3,4,-1,1}));
		System.out.println(new MissingPositiveNumber().firstMissingPositive(new int[] {7,8,9,11,12}));
		
	}
	
	private int firstMissingPositive(int[] nums) {
		int length = nums.length;
		int i = 0;
		
		while (i < length) {
			if (nums[i] - 1 >= 0 && nums[i] - 1  != i && nums[i] <= length) {
				swap(nums, i, nums[i] - 1);
			}else {
				i++;
			}
		}
		
		for (i = 0; i < length; i++) {
			if (i + 1 != nums[i]) {
				return i+ 1;
			}
		}
		
		return length + 1;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
