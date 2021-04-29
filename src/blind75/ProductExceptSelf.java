package blind75;

// 238. Product of Array Except Self
public class ProductExceptSelf {
	
	public static void main(String[] args) {
		new ProductExceptSelf().productExceptSelf(new int[] {1,2,3,4});
	}
	
	public int[] productExceptSelf(int[] nums) {
		// get forward multiplication
		int[] f = new int[nums.length];
		int[] b = new int[nums.length];
		int[] result = new int[nums.length];
		
		f[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			f[i] = f[i-1]* nums[i-1];
		}
		
		b[nums.length - 1] = 1;
		for (int i = nums.length-2; i >= 0; i--) {
			b[i] = b[i+1]* nums[i+1];
		}
		
		for (int i = 0; i < nums.length; i++) {
			result[i] = f[i] * b[i];
		}
		
		print(result);
		return result;
	}
	
	
	private void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(String.format("%d ", nums[i]));
		}
		
	}
	

}
