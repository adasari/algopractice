package blind75;

public class SearchInRotatedSortArray {
	public int search(int[] nums, int target) {
		if (null == nums || nums.length == 0) {
			return -1;
		}
		
		int low = 0;
		int high = nums.length - 1;
		
		int left = 0;
		int right = nums.length -1;
		
		while (low <= high) {
			if (nums[low] < nums[high]) {
				left = low;
				right = high;
				break;
			}
			
			int mid = (high + low)/2;
			
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			}else {
				high = mid;
			}
		}
		
		System.out.println("Min element is - "+ nums[left]);
		
		if (target <= nums[high] && target >= nums[0]) {
			left = 0;
			right = high;
		}else {
			right = nums.length - 1;
			left = low;
		}
		
		while (left <= right) {
			int mid = (left + right)/2;
			if (nums[mid] == target) {
				return mid;
			}
			
			if (target > nums[mid]) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		return 0;
		
	}

}
