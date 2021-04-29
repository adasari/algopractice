package misc;

import java.util.Arrays;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"mint", "mini", "mineral"}));
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"colorado", "color", "cold"}));
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"a", "b", "c"}));
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"spot", "spotty", "spotted"}));
	}
	
	public String longestCommonPrefix(String[] s) {
		Arrays.sort(s);
		
		int length = s[0].length();
		StringBuilder res = new StringBuilder();
		
		for (int i = 0; i < length ; i++) {
			if (s[0].charAt(i) == s[s.length-1].charAt(i)) {
				res.append(s[0].charAt(i));
			}else {
				break;
			}
		}
		return res.toString();
	}
}
