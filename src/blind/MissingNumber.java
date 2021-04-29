package blind;

// by XOR operations.

public class MissingNumber {
	public static void main(String[] args) {
		System.out.println(new MissingNumber().missingNumber(new int[] {3,0,1}));
		System.out.println(new MissingNumber().missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
	}
	
	public int missingNumber(int[] nums) {
		int xor = nums.length;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ i;
		}

		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ nums[i];
		}

		return xor;
	}

}
