package lt;

public class Solution1 {
	
	public static void main(String[] args) {
		System.out.println(new Solution1().reverse(1234));
	}

	private int shuffle(int num) {
		System.out.println(reverse(num));
		
		return -1;
	}
	
	
	//privatre int length
	
	private int reverse(int num) {
		int result = 0;
		while ( num > 0) {
			result = result * 10 + num % 10;
			num = num/10;
		}
		
		return result;
	}
}
