package blind75.string;

import java.util.HashSet;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingChar {
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeatingChar().lengthOfLongestSubstring("pwwkew"));
	}

	// 3. Longest Substring Without Repeating Characters
	public int lengthOfLongestSubstring(String s) {
		int i =0;
		
		int max = Integer.MIN_VALUE;
		HashSet<Character> set = new HashSet<Character>();
		
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (!set.contains(c)) {
				set.add(c);
				max = Math.max(max, set.size());
			} else {
				while (i < j) {
					if (s.charAt(i) == c) {
						i++;
						break;
					}
					
					set.remove(s.charAt(i));
					i++;
				}
			}
		}
			
		return max;
	}

}
