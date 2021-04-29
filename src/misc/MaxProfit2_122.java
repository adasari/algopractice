package misc;

// leet code 122
public class MaxProfit2_122 {
	
	/*

				     S
		B      S    /\
		  \    /\  /  \
		   \  /  \/
		    \/    B
		    B

	 * 
	 */

	public static void main(String[] args) {
		
	}
	
	private int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;
		
		int profit = 0;
		int buy = prices[0];
		
		for (int i = 1;  i < prices.length; i++) {
			if (prices[i] < prices[i-1]) {
				profit += prices[i-1] - buy;
				buy = prices[i];
			}
		}
		
		profit += prices[prices.length-1] - buy;
		
		return profit;
	}	
}
