package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentencesCount {
	
	private int[] countSentenses(String[] wordSet, String[] sentences) {
		if (sentences == null || sentences.length ==  0) return null;		
		int[] result = new int[sentences.length];
		
		Map<String, List<String>> groupAnagrams = groupAnagrams(wordSet);
		
		for (int i = 0; i < sentences.length; i++) {
			result[i] = countSentece(groupAnagrams, sentences[i]);
			System.out.println(result[i]);
		}
		
		return result;
	}
	
	private int countSentece(Map<String, List<String>> groupAnagrams, String sentence) {
		String[] words = sentence.split("\\s+");
		int count  = 0;
		for (int i = 0; i < words.length; i++) {
			String w = getAanagram(words[i]);
			if (groupAnagrams.containsKey(w)) {
				count += groupAnagrams.get(w).size() == 1 ? 0 : groupAnagrams.get(w).size();
			}
		}
		
		return count;
	}
	
	private Map<String, List<String>> groupAnagrams(String[] wordSet) {
		Map<String, List<String>> groups = new HashMap<String, List<String>>();
		for (int i = 0; i < wordSet.length; i++) {
			String a = getAanagram(wordSet[i]);
			List<String> list = groups.get(a);
			if (list == null) {
				list = new ArrayList<>();
				groups.put(a, list);
			}
			
			list.add(wordSet[i]);
		}
		
		return groups;
	}

	
	private String getAanagram(String s) {
		char[] chars = new char[26];
		
		for (int i = 0;  i< s.length(); i++) {
			char ch = s.charAt(i);
			chars[ch-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			while (chars[i] > 0) {
				sb.append((char)(i+97));
				chars[i]--;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
	//	System.out.println(new SentencesCount().getAanagram("bca"));
	//	System.out.println(new SentencesCount().getAanagram("bbbbca"));
		
		new SentencesCount().countSentenses(new String[] {"tabs","bats", "in", "cat", "act"}, new String[] {"cat the bats", "in the act", "act tabs in"});
	}
}
