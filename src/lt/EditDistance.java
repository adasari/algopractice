package lt;

public class EditDistance {
	
	public static void main(String[] args) {
		System.out.println(new EditDistance().findDistance("cat", "bataa"));
	}
	
	private int findDistance(String s, String t) {
		//return helper(s, 0, t, 0);
		return dp(s, t);
	}
	
	private int helper(String s, int i, String t, int j) {
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) != t.charAt(j)) {
				break;
			}
			
			i++;
			j++;
		}
		
		if (i == s.length()) return (t.length()  - j);
		if (j == t.length()) return (s.length() - i);
		
		
		return 1 + Math.min(Math.min(helper(s, i, t, j+1), helper(s, i+1, t, j)),helper(s, i+1, t, j+1)); 
	}
	
	
	private int dp(String s, String t) {
		int[][] dp = new int[s.length()+1][t.length()+1];
		dp[0][0] = 0;
		
		for (int i = 1; i <= s.length(); i++) {
			dp[i][0] = i;
		}
		
		for (int i = 1; i <= t.length(); i++) {
			dp[0][i] = i;
		}
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i-1][i], dp[i-1][j-1]), dp[i][j-1]);
				}
				
			}
		}
		
		return dp[s.length()][t.length()];
	}

}
