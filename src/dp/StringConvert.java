package dp;

public class StringConvert {

	public static void main(String[] args) {
		String s1 = "catck";
		String s2 = "carbh";
		System.out.println(new StringConvert().findMinOperations(s1, s2, 0, 0));
	}

	private int findMinOperations(String s1, String s2, int i, int j) {
		if (s1.length() == i && s2.length() == j) {
			return 0;
		}

		if (s1.length() == i) {
			return s2.length() - j;
		}

		if (s2.length() == i) {
			return s1.length() - i;
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			return findMinOperations(s1, s2, i + 1, j + 1);
		}

		return 1 + Math.min(Math.min(findMinOperations(s1, s2, i + 1, j), findMinOperations(s1, s2, i + 1, j)),
				findMinOperations(s1, s2, i + 1, j + 1));
	}

	private int findMinOperationsTopDown(Integer[][] dp, String s1, String s2, int i, int j) {
		if (dp[i][j] != null) {
			return dp[i][j];
		}


		if (s1.length() == i) {
			dp[i][j] = s2.length() - j;
		}else if (s2.length() == i) {
			dp[i][j] =  s1.length() - i;
			
		}else if (s1.charAt(i) == s2.charAt(j)) {
			dp[i][j] = findMinOperations(s1, s2, i + 1, j + 1);
		}else {
			dp[i][j] =  1 + Math.min(Math.min(findMinOperations(s1, s2, i + 1, j), findMinOperations(s1, s2, i + 1, j)),
					findMinOperations(s1, s2, i + 1, j + 1));
		}

		return dp[i][j];
	}

	// bottom up approach
	private int findMinOperationsBottomUp(String s1, String s2, int i, int j) {
		return 0;
	}
}
