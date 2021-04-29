package lt;

// Leetcode 1295. Find Numbers with Even Number of Digits
public class EvenNumberOfDigits {
	
	public static void main(String[] args) {
		System.out.println(new EvenNumberOfDigits().findNumbers(new int[] {12,345,2,6,7896}));
		System.out.println(new EvenNumberOfDigits().findNumbers(new int[] {555,901,482,1771}));
	}

	public int findNumbers(int[] nums) {
		int finalCount =  0;
		for (int num : nums) {
			if (isEven(num)) {
				finalCount++;
			}
		}
		
		return finalCount;
	}
	
	private boolean isEven(int num) {
		int digits = 0;
		while (num > 0 ) {
			num = num/10;
			digits++;
		}
		
		return (digits % 2 == 0);
	}

}
