package misc;

public class Stairs {

	public static void main(String[] args) {
		System.out.println(new Stairs().solution(3));
	}

	public long solution(long n) {
		// Type your solution h
		/*
		if (n < 0) {
			return 0L;
		} else if (n == 1 || n == 0) {
			return 1L;
		}
		if (n == 2) {
			return 2L;
		}

		return solution(n - 3) + solution(n - 2) + solution(n - 1);
		*/
		
		
		
		long[] dp = new long[(int)n+1];
	      
	      dp[0] = 1;
	      dp[1]= 1;
	      dp[2] = 2;
	      for (int i= 3; i <= n; i++) {
	      	dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
	      }
	      return dp[(int)n];

	}

}
