package grandyang;

public class CountAndSay {
	
	public static void main(String[] args) {
		new CountAndSay().countAndSay(4);
	}
	
	private String countAndSay(int n) {
		String result = "1";
		while (n-- > 0) {
			StringBuilder current = new StringBuilder();
			for (int i = 0; i < result.length(); i++) {
				int count = 1;
				
				while (i + 1 < result.length() && result.charAt(i) == result.charAt(i+1)) {
					i++;
					count++;
				}
				
				current.append(count);
				current.append(result.charAt(i));
			}
			
			result = current.toString();
		}
		
		System.out.println(result);
		return result;
	}

}
