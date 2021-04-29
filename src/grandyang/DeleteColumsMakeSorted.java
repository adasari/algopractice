package grandyang;

public class DeleteColumsMakeSorted {
	
	public static void main(String[] args) {
		new DeleteColumsMakeSorted().minDeletionSize(new String[]{"ca","bb","ac"});
		new DeleteColumsMakeSorted().minDeletionSize(new String[]{"xc","yb","za"});
	}
	
	/*
	 * 
	 * Initial N empty string.
For each column,
add the character to each row,
and check if all rows are still sorted.

If not, we have to delete this column.


Explanation
Initial a boolean array sorted,
sorted[i] = true if and only if A[i] < A[i + 1],
that is to say A[i] and A[i + 1] are sorted.

For each col, we check all unsorted rows.
If A[i][j] > A[i + 1][j], we need to deleted this col, res++.

Otherwise, we can keep this col, and update all sorted rows.
	 */
	
	private int minDeletionSize(String[] A) {
		
		if (A.length == 0) {
	        return 0;
	    }

	    /* set represented rows that already sorted */
		boolean[] sorted = new boolean[A.length];
	    int col, row;
	    int result = 0;
	    for (col = 0; col < A[0].length(); col++) {
	        // if all rows is marked as "sorted", we do not need to go through the rest of columns again
	        // just return current result directly

	        	        // traverse every row to check whether current column is a valid or invalid
	        for (row = 0; row < A.length - 1; row++) {
	            if (!sorted[row] && A[row].charAt(col) > A[row + 1].charAt(col)) {
	                result++;
	                break;
	            }
	        }

	        // if current column is INVALID (current column exists < = and > relationships), we cannot conduct adding
	        // set operations, but we need to delete the entire column, so we have to go to next iteration to check next column

	        if (row != A.length - 1) {
	            continue;
	        }

	        // if current column is VALID (current column only exists < or = relationships)

	        for (int k = 0; k < A.length - 1; k++) {
	        	sorted[row] = sorted[row] | A[k].charAt(col) < A[k + 1].charAt(col);
	        }
	    }
	    return result;
	}

}
