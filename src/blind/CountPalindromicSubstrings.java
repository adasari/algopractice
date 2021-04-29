package blind;

public class CountPalindromicSubstrings {

	public int countSubstrings(String s) {
		int n = s.length();
		int[][] matrix = new int[n][n];

		int count = 0;

		// diagonal elements are single char elements which are palindrome.
		for (int i = 0; i < n; i++) {
			matrix[i][i] = 1;
			count++;
		}

		// single char -> palidrome
		// two char -> if both chars are same
		// more than 2 -> fist and last same and inner substring is same

		for (int col = 1; col < n; col++) {
			// sub string of 0, k is same as k, 0 -> hence only focus on first half of matrix
			for (int row = 0; row < col; row++) {
				// row and col-1 set always creates two char sets
				if (row == col - 1 && s.charAt(row) == s.charAt(col)) {
					matrix[row][col] = 1;
					count++;
				}else if (matrix[row+1][col-1] == 1 && s.charAt(row) == s.charAt(col)) {
					// 3rd case, inner string is palindrome matx[row+1][col-1] == 1, then check first and last chars
					matrix[row][col] = 1;
					count++;
				}
			}
		}

		return count;
	}

	
	public static void main(String[] args) {
		System.out.println(new CountPalindromicSubstrings().countSubstrings("abc"));
		System.out.println(new CountPalindromicSubstrings().countSubstrings("aaa"));
	}
}
