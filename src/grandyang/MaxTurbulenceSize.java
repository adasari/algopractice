package grandyang;

public class MaxTurbulenceSize {
	
	public static void main(String[] args) {
		new MaxTurbulenceSize().maxTurbulenceSize(new int[] {9,4,2,10,7,8,8,1,9}); // 5
		new MaxTurbulenceSize().maxTurbulenceSize(new int[] {4,8,12,16}); // 2
		new MaxTurbulenceSize().maxTurbulenceSize(new int[] {100}); // 1
		
		new MaxTurbulenceSize().maxTurbulenceSizeDP(new int[] {9,4,2,10,7,8,8,1,9}); // 5
		new MaxTurbulenceSize().maxTurbulenceSizeDP(new int[] {4,8,12,16}); // 2
		new MaxTurbulenceSize().maxTurbulenceSizeDP(new int[] {100}); // 1
	}
	
	
	// 978. Longest Turbulent Subarray
	
	private int maxTurbulenceSize(int[] A) {
		if (A == null || A.length == 0) return 0;
			
		int currentLen = 0, maxLength = 0;
		
		for (int k = 0;  k < A.length; k++) {
			if (k >=2 && ((A[k-2] > A[k-1] && A[k-1] < A[k]) || (A[k-2] < A[k-1] && A[k-1] > A[k]))) {
				currentLen += 1;
			} else if (k >= 1 && A[k-1] != A[k]) {
				currentLen = 2;
			}else {
				currentLen = 1;
			}
			
			maxLength = Math.max(currentLen, maxLength);
		}
		
		System.out.println(maxLength);
		
		return maxLength;
	}
	
	/*
	 	dp state:
	  	dp[i][c], length of  turbulent array ending at i
	  	c = 0 if the subarray ending with A[i-1] < A[i]
	  	c = 1 if the subarray ending with A[i-1] > A[i]
	  	
	  	dp[i][0] is the length of turbulent array at i such that A[i-1] < A[i]
	  	dp[i][1] is the length of turbulent array at i such that A[i-1] > A[i]
	  	
	  	if A[i-1] < A[i] :
	  		dp[i][0] = 1 + dp[i-1][1]; 
	  	else if A[i-1] > A[i]:
	  		dp[i][1] = 1 + dp[i-1][0]; 
	  
	  
	  	max(dp[i][0], dp[i][1])
	 */
	
	private int maxTurbulenceSizeDP(int[] A) {
		if (A == null || A.length == 0) return 0;
		int[][] dp = new int[A.length][2];
		
		for (int i = 0; i < A.length; i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
		}
		
		int maxLength = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i-1] < A[i]) {
				dp[i][0] = 1 + dp[i-1][1]; 
			}else if (A[i-1] > A[i]) {
				dp[i][1] = 1 + dp[i-1][0]; 
			}
			
			maxLength = Math.max(maxLength, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(maxLength);
		
		return maxLength;
		
	}

}
