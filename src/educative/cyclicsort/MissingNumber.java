package educative.cyclicsort;

public class MissingNumber {
	
	/*
	public static void main(String[] args) {
		int a[] = new int[] {4,5, 2,1,3};
		
		for (int i = 0; i < a.length; i++) {
			int actualIndex = a[i] - 1;
			if (i != actualIndex) {
				swap(a, i, actualIndex);
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
	}
	*/
	
	public static void main(String[] args) {
		System.out.println(new MissingNumber().findMissingNumber(new int[] {0, 3,1}));
	}
	
	public int findMissingNumber(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int actualIndex = nums[i];
			if (actualIndex < nums.length && nums[actualIndex] != nums[i]) {
				swap(nums, i, actualIndex);
			} else {
				i++;
			}
		}
		
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != j) {
				return j;
			}
		}
		
		return nums.length;
	}

	private static void swap(int[] a, int i, int actualIndex) {
		int temp = a[i];
		a[i] = a[actualIndex];
		a[actualIndex] = temp;
	}

}
