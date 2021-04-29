package blind;

import java.util.Arrays;

// rearranging the chars should be same.
public class Anagram {
	
	public static void main(String[] args) {
		System.out.println(new Anagram().isAnagram("anagram", "nagaram"));
		System.out.println(new Anagram().isAnagram("rat", "cat"));
	}
	public boolean isAnagram(String s, String t) {
		
		if (s.length() != t.length()) return false;
		
		char[] sCharArray  = s.toCharArray();
		char[] tCharArray = t.toCharArray();
		
		Arrays.sort(sCharArray);
		Arrays.sort(tCharArray);
		
		for (int i = 0; i < sCharArray.length; i++) {
			if (sCharArray[i] != tCharArray[i]) return false;
		}
		
		return true;
 	}

}
