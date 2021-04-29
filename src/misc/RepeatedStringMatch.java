package misc;

public class RepeatedStringMatch {
	public static void main(String[] args) {
		System.out.println(new RepeatedStringMatch().repeatedStringMatch("abcd", "cdabcdab"));
		System.out.println(new RepeatedStringMatch().repeatedStringMatch("a", "aa"));
		System.out.println(new RepeatedStringMatch().repeatedStringMatch("a", "a"));
		System.out.println(new RepeatedStringMatch().repeatedStringMatch("abc", "xyz"));
	}

	public int repeatedStringMatch(String a, String b) {
		int result = 1;
		
		String newS = a;
		while (newS.length() < b.length()) {
			newS = newS + a;
			result++;
		}
		
		if (newS.indexOf(b) != -1 ) {
			return result;
		}
		
		newS = newS + a;
		result++;
		
		if (newS.indexOf(b) != -1 ) {
			return result;
		}
		
		return -1;
	}

}
