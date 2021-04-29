package blind;

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		System.out.println(new SearchInRotatedSortedArray().search(new int[] {4,5,6,7,0,1,2}, 0));
	}

	public int search(int[] nums, int target) {
		// find min element
		// search

		// find element -> linear or binary
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		System.out.println("mid "+ left);
		int start = left;
		left = 0;
		right = nums.length - 1;

		if (target >= nums[start] && target <= nums[right]) {
			left = start;
		} else {
			right = start;
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

}
