package lt;

public class KthSmallestLexicographicalOrder {
	
	private int findKthNumber(int n, int k) {
		if (k > n) {
			return -1;
		}
		
		int cur = 1;
		k--;
		
		while (k > 0) {
			int steps = countSteps(n, cur, cur+1);
			if (steps <= k) {
				cur = cur + 1;
				k -= steps;
			}else {
				cur = cur * 10;
				k--;
			}
		}
		
		return cur;
	}
	
	private int countSteps(int n , int cur, int next) {
		int steps = 0;
		while (next <= n) {
			steps = steps + Math.min(n + 1, next) - cur;
			cur = cur * 10;
			next = next * 10;
		}
		
		return steps;
		
	}

}
