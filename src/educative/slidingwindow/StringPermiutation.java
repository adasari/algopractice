package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermiutation {
	
	private boolean findPermutation(String str, String pattern) {
		int windowStart = 0;
		
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
			
		}
		
		int  matched = 0;
		// improvement.. check till str.length() - pattern.length();
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			
			char rightChar = str.charAt(windowEnd);
			if (frequencyMap.containsKey(rightChar)) {
				frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) - 1);
				if (frequencyMap.get(rightChar) == 0) {
					// a single char group is macthed.
					matched++;
				}
			}
			
			if (frequencyMap.size() == matched) {
				return true;
			}
				
			if (windowEnd > pattern.length() - 1) {
				char leftChar = str.charAt(windowStart);
				windowStart++;
				if (frequencyMap.containsKey(leftChar)) {
					
					if (frequencyMap.get(leftChar) == 0) {
						matched--;
					}
					
					frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
					
				}
			}
		}
		
		
		return false;
	}
	

}
