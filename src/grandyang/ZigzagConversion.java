package grandyang;

public class ZigzagConversion {
	/*
	 * To solve the problem, we are going to have two concepts interval and step to find the underlying relationship between the original input string and output zigzag pattern string.

Interval indicates the distance between two vertical columns.

Step indicates the distance between middle characters and vertical columns.

Interval is 2n – 2 where n is the input number of rows and step is interval – 2i where i is the index of the row.
	 * 
	 * 
	 */
	
	private String convert(String s, int numRows) {
		int length = s.length();
		
		if (length <=1 || numRows >= length) {
			return s;
		}
		
		int interval = 2 * numRows - 2;
		int count =0;
		
		char[] zigzagChars = new char[length];
		 
		for (int i = 0; i < numRows; i++) {
			int step = interval - 2 * i;
			
			for (int j = i; j < length; j += interval) {
				zigzagChars[count] = s.charAt(j);
				count++;
				
				if (step > 0 && step < interval && j + step < length) {
					zigzagChars[count] = s.charAt(j + step);
					count++;
				}
			}
			
		}
		
		
		return new String(zigzagChars);
	}

}
