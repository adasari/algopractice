package blind;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
	
	public static void main(String[] args) {
		new LongestSubstring().lengthOfLongestSubstring("abcbbb");
	}

	public int lengthOfLongestSubstring(String s) {
		int i = 0;
		int j = 0;
		Set<Character> set = new HashSet<>();
		int max = 0;
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				
				max = Math.max(max, set.size());
				
			}else {
				set.remove(s.charAt(i));
				i++;
				
			}
		}

		System.out.println(max);
		return max;
	}

}
