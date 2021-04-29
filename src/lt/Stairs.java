package lt;

public class Stairs {
	
	public static void main(String[] args) {
		new Stairs().numOfWays(2);
		new Stairs().numOfWays(3);
	}

	
	private int numOfWays(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int  i = 2; i <= n; i++) {
			dp[i] = dp[i-1]+ dp[i-2];
		}
		
		System.out.println(dp[n]);
		return dp[n];
	}
}
