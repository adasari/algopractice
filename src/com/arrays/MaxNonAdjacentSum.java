package com.arrays;

/*
 Given a list of positive numbers, find the largest possible set such that no elements are adjacent numbers of each other.

Here's some example and some starter code

def maxNonAdjacentSum(nums):
  # Fill this in.
  
print(maxNonAdjacentSum([3, 4, 1, 1]))
# 5
# max sum is 4 (index 1) + 1 (index 3)

print(maxNonAdjacentSum([2, 1, 2, 7, 3]))
# 9
# max sum is 2 (index 0) + 7 (index 3)
 
 */

public class MaxNonAdjacentSum {
	
	
	public static void main(String[] args) {
		int[] n =  {2, 1, 2, 7, 3};
		System.out.println(maxNonAdjacentSum(n));
		
		int[] m = {3, 4, 1, 1};
		System.out.println(maxNonAdjacentSum(m));
		
	}

	private static int maxNonAdjacentSum(int[] a) {
		int[] dp = new int[a.length];
		boolean[] v = new boolean[a.length];
		return maxNonAdjacentSum(a, dp, v, 0);
	}
	
	private static int maxNonAdjacentSum(int[] a, int[] dp, boolean[] v, int i) {
		if (i >= a.length) {
			return 0;
		}
		
		if (v[i]) {
			return dp[i];
		}
		
		dp[i] = Math.max(maxNonAdjacentSum(a, dp, v, i + 1), a[i]+maxNonAdjacentSum(a, dp, v, i + 2));
		
		return dp[i];
	}
}
