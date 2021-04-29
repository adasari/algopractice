package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOfTypes {

	private int findLength(char[] arr) {
		int windowStart = 0, windowEnd = 0;
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		int maxLength = 0;
		
		for (windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			frequencyMap.put(arr[windowEnd], frequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
			
			while (frequencyMap.size() > 2) {
				frequencyMap.put(arr[windowEnd], frequencyMap.get(arr[windowEnd]) - 1);
				windowStart++;
				if (frequencyMap.get(arr[windowEnd]) == 0) {
					frequencyMap.remove(arr[windowEnd]);
				}
			}
			
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1); 
		}
		
		return maxLength;
	}
}
