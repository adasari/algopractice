package grandyang;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeatingChar().lengthOfLongestSubstring("abcabcbb".toCharArray()));
		System.out.println(new LongestSubstringWithoutRepeatingChar().lengthOfLongestSubstring("bbbbb".toCharArray()));
	}
	
	private int lengthOfLongestSubstring(char[] chars) {
		int i = 0; 
		int j = 0;
		
		int result = Integer.MIN_VALUE;
		Map<Character, Integer> charIndexMap = new HashMap<>();
		while (j < chars.length) {
			char c = chars[j];
			if (charIndexMap.containsKey(c)) {
				int idx = charIndexMap.get(c);
				result = Math.max(j - i , result);
				i = idx+1;
			}
			
			charIndexMap.put(c, j);
			j++;
		}
		
		return result;
	}

}
