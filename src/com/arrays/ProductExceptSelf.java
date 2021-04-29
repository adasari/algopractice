package com.arrays;

// https://www.youtube.com/watch?v=tSRFtR3pv74

public class ProductExceptSelf {

	// get forward direction multiplication
	// get backward direction multiplication
	// multiple above 2
	public static void main(String[] args) {
		int[] n = {4, 5, 1, 8, 2};
		print(productExceptSelf(n));
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int[] o = new int[nums.length];
		
		o[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			o[i] = o[i-1] * nums[i-1];
		}
		
		int result = 1;
		for (int i = nums.length -1 ; i >= 0; i--) {
			o[i] = o[i] * result;
			result = result * nums[i];
		}
		
		
		return o;
	}
	
	
/*// non optmized
	public static int[] productExceptSelf(int[] nums) {
		int[] f = new int[nums.length];
		int[] b = new int[nums.length];
		
		f[0] = 1;
		b[nums.length - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			f[i] = f[i-1] * nums[i-1];
		}
		
		for (int i = nums.length -2 ; i >= 0; i--) {
			b[i] = b[i+1] * nums[i+1];
		}
		
		print(f);
		print(b);
		
		
		for (int i = 0; i < nums.length; i++) {
			f[i] = f[i] * b[i];
		}
		
		return f;
	}
	*/

	public static void print(int[] nums) {
		for (int n : nums) {
			System.out.printf("%d ", n);
		}
		
		System.out.println();
	}
}
