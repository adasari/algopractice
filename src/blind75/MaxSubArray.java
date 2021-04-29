package blind75;

// 53. Maximum Subarray
public class MaxSubArray {

	public static void main(String[] args) {
		System.out.println(new MaxSubArray().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
/*
	public int maxSubArray(int[] nums) {
		if (nums.length == 1) return nums[0];
		
		int sum = Integer.MIN_VALUE;
		int currentSum = nums[0];
		for (int i = 1; i < nums.length ; i++) {
			int num = nums[i];
			currentSum = Math.max(currentSum+num, num);
			sum = Math.max(sum, currentSum);
		}
		
		return sum;
	}
*/	
	
	// divide and conquer
	public int maxSubArray(int[] nums) {
		return helper(nums, 0, nums.length-1);
	}
	
	
	// divide and conquer
	public int helper(int[] nums, int l, int h) {
		if (l >= h) return nums[l];
		
		int m = (l + h )/2;
		
		/* Return maximum of following three  
	    possible cases: 
	    a) Maximum subarray sum in left half 
	    b) Maximum subarray sum in right half 
	    c) Maximum subarray sum such that the  
	    subarray crosses the midpoint */
		
		int ls = helper(nums, l, m-1);
		int rs = helper(nums, m+1, h);
		
		return Math.max(
				Math.max(ls, rs),
				maxSubArrayCrossSum(nums, l, h, m)
				);
	}

	private int maxSubArrayCrossSum(int[] nums, int l, int h, int m) {
		int sum = nums[m];
		int currentSum = sum;
		for (int i = m - 1 ; i >= l; --i) {
			currentSum = currentSum + nums[i];
			sum = Math.max(currentSum, sum);
		}
		
		currentSum = sum;
		for (int i = m + 1 ; i <= h; ++i) {
			currentSum = currentSum + nums[i];
			sum = Math.max(currentSum, sum);
		}
		
		return sum;
	}
}
