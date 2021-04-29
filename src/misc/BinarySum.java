package misc;

public class BinarySum {

	public static void main(String[] args) {
		System.out.println(new BinarySum().addBinary("101", "11"));
	}

	private String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;

		StringBuilder result = new StringBuilder();
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) {
				sum += a.charAt(i) - '0';
				i--;
			}
			
			if (j >= 0) {
				sum += b.charAt(j) - '0';
				j--;
			}
			
			result.append(sum % 2);
			carry = sum/2;
		}
		
		if (carry != 0) {
			result.append(carry);
		}
		
		return result.reverse().toString();
	}
}
