package grandyang;

import java.util.Arrays;

/*
 * LeetCode] 948. Bag of Tokens
 * 
 * Sort tokens.
Buy at the cheapest and sell at the most expensive.
 */
public class BagOfTokensScore {
	public int bagOfTokensScore(int[] A, int P) {
		Arrays.sort(A);
		
		int i = 0;
		int j = A.length - 1;
		int result = 0;
		int points = 0;
		while (i <= j) {
			if (P > A[i]) {
				P -= A[i];
				i++;
				points++;
				result = Math.max(result, points);
				
			}else if (points > 0) {
				points--;
				P += A[j--];
			} else {
				break;
			}
		}
		
		return result;
	}
}
