package com.greedy;

public class MaxProfit {
	/*
	public static void main(String[] args) {
		
		int[] sp = {100, 120, 150, 200, 80, 50, 110, 150, 200, 210};
		int buy = 0, sell = 0, profit = 0;
		int maxStockPrice = sp[0], minStockPrice = sp[0];
		
		for (int i = 1; i < sp.length; i++) {
			if (maxStockPrice < sp[i]) {
				maxStockPrice = sp[i];
			}else if (minStockPrice > sp[i]) {
				if ((maxStockPrice - minStockPrice) > profit) {
					buy = minStockPrice;
					sell = maxStockPrice;
					profit = sell - buy;
				}
				
				minStockPrice = maxStockPrice = sp[i];
			}
		}
		
		if ((maxStockPrice - minStockPrice) > profit) {
			buy = minStockPrice;
			sell = maxStockPrice;
			profit = sell - buy;
		}
		
		System.out.println("Max Profit : " + profit + " when we buy at : "
				+ buy + " and sell at : " + sell);
	}
*/
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
		
		
		int[] p = {7,6,4,3,1};
		System.out.println(maxProfit(p));
		
		System.out.println(maxProfit(new int[] {10, 7, 5, 8, 11, 9}));
	}
	
	
	public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
      int maxStockPrice = prices[0], minStockPrice = prices[0];
      int profit = 0;
      for (int i = 1; i < prices.length; i++) {
          if (minStockPrice > prices[i]) {
              if ((maxStockPrice - minStockPrice) > profit) {
                  profit = (maxStockPrice - minStockPrice);
              }
              
              minStockPrice = maxStockPrice = prices[i];
          }else if (maxStockPrice < prices[i]) {
              maxStockPrice = prices[i];
          }
      }
        
        if ((maxStockPrice - minStockPrice) > profit) {
                  profit = (maxStockPrice - minStockPrice);
          }
    
      return profit;
    }
	
}
