package grandyang;

public class MinAddToMakeValid {
	
	public static void main(String[] args) {
		new MinAddToMakeValid().minAddToMakeValid("())");
		new MinAddToMakeValid().minAddToMakeValid("(((");
		new MinAddToMakeValid().minAddToMakeValid("()");
		new MinAddToMakeValid().minAddToMakeValid("()))((");
	}
	
	private int minAddToMakeValid(String S) {
		int result = 0;
		
		int open = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(') {
				open++;
			} else {
				if (open > 0) {
					open--;
				} else {
					result++;
				}
			}
			
		}
		
		System.out.println(result + open);
		return result + open;
	}

}
