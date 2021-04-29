package grandyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumsSameConsecDiff {

	private List<Integer> numsSameConsecDiff(int n, int k) {
		List<Integer> result = new ArrayList<>();
		if (n == 1) {
			return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		}

		for (int i = 1; i <= 9; i++) {
			dfs(i, n-1, k, result);
		}

		return result;
	}

	private void dfs(int num, int n, int k, List<Integer> result) {
		if (n == 0) {
			result.add(num);
			return;
		}
		
		int digit = num % 10;
		
		if (digit + k <=9 ) {
			// 181 scenario
			dfs(num * 10 + digit + k, n-1, k, result);
		}
		
		// 818 scenario
		if (k != 0 && digit - k >= 0) dfs(num * 10 + digit - k, n-1, k, result);
	}
}
