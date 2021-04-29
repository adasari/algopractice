package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimunWindowSubstring {
	
	private String findSubstring(String str, String pattern) {
		
		int start = 0; String result = "";
		Map<Character, Integer> frequencyMap = new HashMap<>();
		int matched = 0;
		
		// prepare frequency map for pattern.
		
		for (int end = 0; end < str.length(); end++) {
		    char rightChar = str.charAt(end);
			if (frequencyMap.containsKey(rightChar)) {
				frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
				
				if (frequencyMap.get(rightChar) == 0) {
					matched++;
				}
			}
			
			while (matched == frequencyMap.size()) {
				if (result.length() > end - start + 1) {
					result = str.substring(start, end + 1);
				}
				
				char leftChar = str.charAt(start++);
				if (frequencyMap.containsKey(leftChar)) {
					if (frequencyMap.get(leftChar) == 0) {
						matched--; 
					}
					
					frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
				}
			}
			
			
		}
		
		return result;
	}

}
