package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringWindow {
	
	private String findSubstring(String str, String pattern) {
		String result = "";
		int minLength = str.length();
		int matched = 0;
		int windowStart = 0;
		Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
		for (Character c : pattern.toCharArray()) {
			patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
		}
		
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			Character rightChar = str.charAt(windowEnd);
			if (patternMap.containsKey(rightChar)) {
				patternMap.put(rightChar, patternMap.get(rightChar) - 1);
				
				if (patternMap.get(rightChar) == 0) {
					matched++;
				}
				
				while (patternMap.size() == matched) {
					if (result.length() > (windowEnd - windowStart + 1)) {
						result = str.substring(windowStart, windowEnd+1);
					}
					
					char leftChar = str.charAt(windowStart);
					windowStart++;
					
					if (patternMap.containsKey(leftChar)) {
						if (patternMap.get(leftChar) == 0) {
							matched--;
						}
						
						patternMap.put(leftChar, patternMap.get(leftChar) + 1);
					}
				}
				
			}
		}
		
		return result;
	}

}
