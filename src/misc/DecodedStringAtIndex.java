package misc;

public class DecodedStringAtIndex {
	
	private String decodeAtIndex(String S, int K) {
		StringBuilder sb = new StringBuilder();
		int stringLength = 0;
		
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (Character.isAlphabetic(ch)) {
				if (stringLength == K-1) {
					return String.valueOf(S.charAt(stringLength));
				}
				
				stringLength++;
			} else {
				if (stringLength * (ch - '0') >= K) {
					return decodeAtIndex(S.substring(0, i), (K-1)%stringLength+1);
				} else {
					stringLength *= (ch - '0');
				}
			}
		}
		
		return "";
			
		
		/*
		
		int i = 0;
		while (i < K) {
			
			char ch = S.charAt(i);
			if (Character.isDigit(ch)) {
				String strSofar = sb.toString();
				if (i + strSofar.length() < K) {
					sb.append(strSofar);
					i = sb.length();
				} else {
					int remaining = K - i;
					System.out.println(strSofar.charAt(remaining));
					return String.valueOf(strSofar.charAt(remaining));
				}
			} else {
				sb.append(ch);
			}
			
			
			
		}
		
		return null;
		*/
	}

}
