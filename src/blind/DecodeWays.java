package blind;

public class DecodeWays {
	/*
	 * number of ways of length zero is represented = 0
	 * number of ways of length 1 is represented = 0 or 1 as char must be have mapping
	 * number of ways of length 2 is repesented = number of ways current char 1 is represented + nunber of ways previous chars represented
	 *               + ways of mapping of 2 chars exits
	 */
	
	
	public int numDecodings(String s) {
		
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = (s.charAt(0) == '0') ? 0 : 1;
		
		for (int i = 2; i < s.length(); i++) {
			int oneChar = Integer.valueOf(s.substring(i-1, i));
			int twoChar = Integer.valueOf(s.substring(i-2, i));
			
			if (oneChar != 0) {
				dp[i] += dp[i-1];
			}
			
			if (twoChar >= 10 && twoChar <=26) {
				dp[i] += dp[i-2];
			}
		}
		
		return dp[s.length()];
	}

}

