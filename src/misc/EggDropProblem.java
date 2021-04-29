package misc;

public class EggDropProblem {
	
	public static void main(String[] args) {
		System.out.println(new EggDropProblem().minTries(8, 4));
	}
	
	private int minTries(int n, int e) {
		int[][] dp = new int[n+1][e+1];
		
		// rows - number of floors
		// cols - number of eggs for try (to be dropped)
		// dp[1][e] = 1 .. one floor , any number of eggs (e) .. only 1 try to check of egg break.
		// dp[n][1] = number of floors .. n number of floors with single egg.. number of tries are n
		
		/*
		  assume x is floor.. 
		  possible options with single try
		  1. egg  break -> you left with e-1 eggs, x-1 floors to check where it is breaking
		  2. egg not break -> left with n-x floors and e eggs
		  
		  Total number of floors in a building =
				current floor
				+ floors explored when egg breaks at current(bottom to current-1)
				+ floors explored when egg doesn’t break at current(current+1 to top)
		  
		 */
		// dp[n][e] = min from 1 -> n- 1 with ( max (dp[n-x][e], dp[x-1][e-1]) + 1 (single try)
		
		for (int i = 1; i <= n; i++) {
			dp[i][1] = i;
		}
		
		for (int i = 1; i <= e; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= e; j++) {
				int res = Integer.MAX_VALUE;
				for (int x = 1; x < i; x++) {
					res = Math.min(res, Math.max(dp[i - x][j], dp[x-1][j-1]) + 1);
				}
				
				dp[i][j] = res;
			}
		}
		
		return dp[n][e];
	}

}
