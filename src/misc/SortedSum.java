package misc;

public class SortedSum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int i = 0;
		int j = nums.length - 1;
		int target = 3;

		boolean found = false;

		while (i <= j) {
			int sum = nums[i] + nums[j];
			if (sum > target) {
				j--;
			} else if (sum < target) {
				i++;
			} else {
				found = true;
				break;
			}
		}

		if (found) {
			System.out.println(i + " " + j);
		} else {
			System.out.println("Not found");
		}
	}

}
