package sep;

public class HouseRobber {

	public static void main(String[] args) {
		System.out.println(new HouseRobber().rob(new int[] {1,2,3,1}));
		System.out.println(new HouseRobber().rob(new int[] {2,7,9,3,1}));
		
		System.out.println(new HouseRobber().robDP(new int[] {1,2,3,1}));
		System.out.println(new HouseRobber().robDP(new int[] {2,7,9,3,1}));
	}
	
	
	public int rob(int[] nums) {
		return rob(nums, 0);
	}

	
	private int rob(int[] nums, int i) {
		if (i >= nums.length) {
			return 0;
		}
		
		return Math.max(nums[i] + rob(nums, i + 2), rob(nums, i+1));
	}
	
	private int robDP(int[] nums) {
		int[] dp = new int[nums.length + 1];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
		}	
		
		return dp[nums.length-1];
	}
}
