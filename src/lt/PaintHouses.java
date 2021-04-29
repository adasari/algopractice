package lt;

public class PaintHouses {
	
	public static void main(String[] args) {
		System.out.println(new PaintHouses().minCost(new int[][] {{1, 3, 5},{2, 4, 6},{5, 4, 3}}));
	}
	
	private int minCost(int[][] costs) {
		int[][] dp = new int[costs.length][costs[0].length];
		
		// painting each color on first house
		for (int i = 0; i < costs[0].length; i++) {
			dp[0][i] = costs[0][i];
		}
		
		for (int i = 1; i < costs.length;i++) {
			dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = costs[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
		}
		
		int row = costs.length - 1;
		return Math.min(Math.min(dp[row][0], dp[row][1]), dp[row][2]);
	}

}
