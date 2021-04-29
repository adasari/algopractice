package blind75;

// 153. Find Minimum in Rotated Sorted Array
public class FindMin {
	
	public static void main(String[] args) {
		System.out.println(new FindMin().findMin(new int[] {4,5,6,7,0,1,2}));
		System.out.println(new FindMin().findMin(new int[] {3,4,5,2}));
		System.out.println(new FindMin().findMin(new int[] {3,4,5,1, 2}));
		System.out.println(new FindMin().findMin(new int[] {3,4,5,6,7}));
		
	}

	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			if (nums[low] <= nums[high]) {
				return nums[low];
			}
			
			int mid = (high + low)/2;
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		
		return -1;
	}
}
