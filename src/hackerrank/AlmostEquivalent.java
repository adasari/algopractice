package hackerrank;

public class AlmostEquivalent {
	
	public static void main(String[] args) {
		System.out.println(new AlmostEquivalent().areEqual("aaaaaa", "bbabbc") ? "Equal" : "Not Equal");
	}

	
	private boolean areEqual(String s, String t) {
		int[] countArray = new int[26];
		if (s.length() != t.length()) {
			return false;
		} else {
			
			for (int j =0; j < s.length(); j++) {
				char c = s.charAt(j);
				countArray[c - 'a'] = countArray[c - 'a'] +1;
			}
			
			
			for (int j = 0; j < t.length(); j++) {
				char c = t.charAt(j);
				countArray[c - 'a'] = countArray[c - 'a'] - 1;
			}
			
			for (int j = 0; j < countArray.length; j++) {
				if (countArray[j] >  3) {
					return false;
				}
			}
		}
		
		return true;
	}
}
