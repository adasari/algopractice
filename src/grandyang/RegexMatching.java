package grandyang;

public class RegexMatching {
	
	private boolean isMatch(String s, String p) {
		if (p.length() == 0) return s.length() == 0;
		
		// both first chars are same or parttern first char is period (.)
		boolean firstCharMarch = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
		
		// check second char is * -> then it can be zero match or multiple match
		if (p.length() >= 2 && p.charAt(1) == '*') {
			// zero match || multiple match
			return isMatch(s, p.substring(2)) || firstCharMarch && isMatch(s.substring(1), p);
		}else {
			return firstCharMarch && isMatch(s.substring(1), p.substring(1));
		}
	}
}
