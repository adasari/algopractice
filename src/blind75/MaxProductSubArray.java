package blind75;

// 152. Maximum Product Subarray
public class MaxProductSubArray {

	public static void main(String[] args) {
		new MaxProductSubArray().maxProduct(new int[]{2,3,-2,4});
		new MaxProductSubArray().maxProduct(new int[]{-2,0,-1});
	}
	// [2,3,-2,4]
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int currentMin = nums[0];
		int currentMax = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int incuded = currentMin * nums[i]; // previous negative and current negative scenario
			int excluded = currentMax * nums[i]; // previous +ve and current +ve scenario
			
			currentMax = Math.max(Math.max(incuded, excluded), nums[i]);
			currentMin = Math.max(Math.max(incuded, excluded), nums[i]);
			
			if (max < currentMax) {
				max = currentMax;
			}
		}
		
		System.out.println(max);
		return max;
	}

}
