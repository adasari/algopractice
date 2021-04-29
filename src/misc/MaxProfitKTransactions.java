package misc;

public class MaxProfitKTransactions {
	
	// profit[t][d] = profit on t tx and on day d
	
	// profit[t][d] = max of 1. profit[t-1][d]   
	//						 2. prices[d] + max of (-prices[x] + profit[t-1][x]) , 0 <= x < d
	                       
	 // #1 -> no tx on the day 't', so max profit of t-1 tx's on day d
	 // #2 -> max profit achieved on t - 1 tx with buy on day
	
	
	// 0(n * n * k)
	private int maxProfit(int[] prices, int k) {
		if (prices == null || prices.length == 0 || k <= 1) return 0;
		
		int length = prices.length;
		// why k+1 , considering 0 tx.
		int[][] profits = new int[k+1][length];
		
		// 0 number of tx -> no profit.
		for (int d = 0; d  < length; d++) {
			profits[0][d] = 0;
		}
		
		// buy starts from first day, so no profit.
		for (int t = 0; t < k + 1; t++) {
			profits[t][0] = 0;
		}
		
		// t is tx, d is day
		for (int t =  1; t < k + 1; t++) {
			for (int d = 1; d < length; d++) {
				int maxSoFar = 0;
				for (int x = 0; x < d; x++) {
					maxSoFar = Math.max(profits[t-1][x] - prices[x], maxSoFar);
				}
				
				profits[t][d] = Math.max(profits[t][d-1], maxSoFar + prices[d]);
			}
		}
		
		return profits[k][length-1];
	}
	
	// store maxSoFar in another array to improve the time complexity from O(n * n* k) to O(n * k)
	private int maxProfit2(int[] prices, int k) {
		if (prices == null || prices.length == 0 || k <= 1) return 0;
		
		int length = prices.length;
		// why k+1 , considering 0 tx.
		int[][] profits = new int[k+1][length];
		
		// 0 number of tx -> no profit.
		for (int d = 0; d  < length; d++) {
			profits[0][d] = 0;
		}
		
		// buy starts from first day, so no profit.
		for (int t = 0; t < k + 1; t++) {
			profits[t][0] = 0;
		}
		
		// t is tx, d is day
		for (int t =  1; t < k + 1; t++) {
			int maxSoFar = Integer.MIN_VALUE;
			for (int d = 1; d < length; d++) {
				maxSoFar = Math.max(maxSoFar, profits[t-1][d-1] - prices[d-1]);
				profits[t][d] = Math.max(profits[t][d-1], maxSoFar + prices[d]);
			}
		}
		
		return profits[k][length-1];
	}

}
