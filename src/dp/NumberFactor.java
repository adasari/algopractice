package dp;

// Number of ways a sum of giving numbers is possible
// Number to use : 1,3,4
// n = 5
// 
public class NumberFactor {
	public static void main(String[] args) {
		System.out.println(new NumberFactor().waysToGetN(7));
	}
	
	private int waysToGetN(int n) {
		int[] dp = new int[n+1];
		dp[0] = dp[1] = dp[2] = 1;
		dp[3] = 2;
		
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
		}
		
		return dp[n];
	}
	
	/*
	// divide and conquer
	private int waysToGetN(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return 1; // {1} for 1 or {1,1} for 2
		}
		
		if (n == 3) {
			return 2; // {1, 1, 1}, {3}
		}
		
		int ways1 = waysToGetN(n-1);
		int ways2 = waysToGetN(n-3);
		int ways3 = waysToGetN(n-4);
		
		return ways1 + ways2 + ways3;
	}

*/
	
}
