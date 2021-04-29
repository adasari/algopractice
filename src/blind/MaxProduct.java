package blind;

public class MaxProduct {

	/*
	public int maxProduct(int[] nums) {
		int maxProduct = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int withCurrent = maxProduct * nums[i];
			if (withCurrent > maxProduct) {
				maxProduct = withCurrent;
			}else if (nums[i] > maxProduct) {
				maxProduct = nums[i];
			}
		}
		
		return maxProduct;
	}
	*/
	
	public int maxProduct(int[] nums) {
		int finalMax = nums[0];
		int currentMin = nums[0];
		int currentMax = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int temp = currentMax;
			currentMax = Math.max(Math.max(currentMin * nums[i], currentMax * nums[i]), nums[i]);
			currentMin = Math.min(Math.min(temp * nums[i], currentMin * nums[i]), nums[i]);
			
			if (currentMax > finalMax) {
				finalMax = currentMax;
			}
		}
		
		return finalMax;
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxProduct().maxProduct(new int[] {2,3,-2,4}));
		System.out.println(new MaxProduct().maxProduct(new int[] {-2,0,-1}));
	}
	
	//private int maxProduct(int[] nums)

}
