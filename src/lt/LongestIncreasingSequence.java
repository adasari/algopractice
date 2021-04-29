package lt;

import java.util.Arrays;

public class LongestIncreasingSequence {
	
	private int length(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		int maxLength = -1;
		int[] dp = new int[nums.length];
		// min longest increasing sub sequence is 1
		Arrays.fill(dp, 1);
		
		for (int i = 1;  i < nums.length; i++) {
			
			for (int j = 0; j < i;j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				
				maxLength = Math.max(maxLength, dp[i]);
			}
			
		}
		
		return maxLength;
	}
	
}
