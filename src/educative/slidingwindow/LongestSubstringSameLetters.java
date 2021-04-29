package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringSameLetters {
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringSameLetters().find("aabccbb", 2));
	}
	
	private int find(String s, int k) {
		int start = 0;
		int maxFrequentElementCount = 0;
		
		int result = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			maxFrequentElementCount = Math.max(maxFrequentElementCount, map.get(ch));
			
			if (end - start + 1 - maxFrequentElementCount > k) {
				char leftChar = s.charAt(end);
				map.put(leftChar, map.get(leftChar) - 1);
				start++;
				
			}
			
			result = Math.max(result, end - start + 1);
		}
		
		return result;
	}
	
	
	private int findLength(String str, int k) {
		int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
		
		Map<Character, Integer> letterFrequenfyMap = new HashMap<>();
		
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			letterFrequenfyMap.put(rightChar, letterFrequenfyMap.getOrDefault(rightChar, 0) + 1);
			
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequenfyMap.get(rightChar));
			
			if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
				char leftChar = str.charAt(windowStart);
				
				letterFrequenfyMap.put(leftChar, letterFrequenfyMap.get(leftChar) - 1);
				windowStart++;
			}
			
			
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		
		return maxLength;
		
	}

}
