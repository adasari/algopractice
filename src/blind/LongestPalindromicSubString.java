package blind;

// LeetCode 5. Longest Palindromic Substring 
public class LongestPalindromicSubString {
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubString().longestPalidromicSubString("cbbd"));
	}

	public String longestPalidromicSubString(String s) {
		if (s == null || s.length() == 0)
			return "";

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len = expandFromMiddle(s, i, i);
			int len2 = expandFromMiddle(s, i, i + 1);

			len = Math.max(len, len2);
			if (len > (end - start)) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandFromMiddle(String s, int left, int right) {
		System.out.println(s.substring(left, right));
		if (left > right)
			return 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return right - left + 1;
	}

}
