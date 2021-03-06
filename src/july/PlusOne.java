package july;

/*
Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

*/
public class PlusOne {

	public static void main(String[] args) {
		print(new PlusOne().plusOne(new int[] {0, 9,9,9}));
	}
	
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i] = digits[i] + 1;
				return digits;
			}
		}

		return digits;
	}
	
	private static void print(int[] a) {
		for (int i : a) {
			System.out.printf("%d ", i);
		}
	}
}
