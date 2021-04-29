package blind;

public class ProductExceptSelf {
	// forward multiplication
	// backward multiplication
	// multiply both
	
	public int[] productExceptSelf(int[] nums) {
		int[] forward = new int[nums.length];
		int[] backward = new int[nums.length];
		int[] result = new int[nums.length];
		
		forward[0] = 1;
		System.out.printf("%d ", forward[0]);
		for (int i =1; i < nums.length; i++) {
			forward[i] = forward[i-1] * nums[i-1];
			System.out.printf("%d ", forward[i]);
		}
		
		System.out.println();
		
		backward[nums.length-1] = 1;
		
		for (int i = nums.length - 2; i >= 0 ; i--) {
			backward[i] = backward[i+1] * nums[i+1];
			System.out.printf("%d ", backward[i]);
		}
		System.out.printf("%d ", backward[nums.length-1]);
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			result[i] = forward[i] * backward[i];
			System.out.printf("%d ", result[i]);
		}
		
		System.out.println();
		return result;
	}
	
	public static void main(String[] args) {
		new ProductExceptSelf().productExceptSelf(new int[] {1,2,3,4});
	}
}
