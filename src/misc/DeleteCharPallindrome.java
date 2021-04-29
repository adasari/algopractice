package misc;

public class DeleteCharPallindrome {

	public static void main(String[] args) {
		 System.out.println(new DeleteCharPallindrome().validPalindrome("abcba"));
		 System.out.println(new DeleteCharPallindrome().validPalindrome("foobof"));
		 System.out.println(new DeleteCharPallindrome().validPalindrome("abccab"));

		//System.out.println(new DeleteCharPallindrome().isPalindromeRange("foobof", 3, 3));
	}

	public boolean isPalindromeRange(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	private boolean validPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
			}
		}

		return true;
	}

}
