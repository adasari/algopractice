package com.greedy;

public class CoinChangeProblem {
	
	public static void main(String[] args) {
		int[] coins = {20, 10, 5, 2};
		int n = 53;
		
		int  i= 0;
		while(n > 0 && i < coins.length) {
			if (coins[i] > n) {
				i++;
				continue;
			}
			
			System.out.printf("%d ",coins[i]);
			n = n - coins[i];
		}
		
		if (n != 0) {
			System.out.println("\nchange is not available");
		}
	}

}
