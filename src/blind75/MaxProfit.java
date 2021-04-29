package blind75;

// 121. Best Time to Buy and Sell Stock
public class MaxProfit {
	
	public static void main(String[] args) {
		System.out.println(new MaxProfit().maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(new MaxProfit().maxProfit(new int[] {7,6,4,3,1}));
	}

	public int maxProfit(int[] prices) {
		if (null == prices || prices.length == 0) {
			return 0;
		}
		
		int min = prices[0];
		int result = 0;
		
		for (int i = 1; i < prices.length; i++) {
			result = Math.max(result, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		
		return result;
	}

}
