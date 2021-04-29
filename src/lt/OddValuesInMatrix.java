package lt;

public class OddValuesInMatrix {
	public static void main(String[] args) {
		System.out.println(new OddValuesInMatrix().oddCellsNew(2, 3, new int[][] {{0,1}, {1,1}}));
		System.out.println(new OddValuesInMatrix().oddCellsNew(2, 2, new int[][] {{1,1}, {0,0}}));
	}
	public int oddCells(int n, int m, int[][] indices) {
		/*
		int[] rows = new int[n];
		int[] cols = new int[m];

		int[][] matrix = new int[n][m];

		for (int[] index : indices) {
			int row = index[0];
			int col = index[1];

			rows[row] = rows[row] + 1;
			cols[col] = cols[col] + 1;
		}

		// rows increment
		for (int row = 0; row < n; row++) {
			for (int i = 0; i < m; i++) {
				matrix[row][i] = matrix[row][i] + rows[row];
			}
		}

		for (int col = 0; col < m; col++) {
			for (int i = 0; i < n; i++) {
				matrix[i][col] = matrix[i][col] + cols[col];
			}
		}
		*/
		
		int[][] matrix = new int[n][m];
		
		for (int[] index : indices) {
			int row = index[0];
			int col = index[1];
			
			for (int i = 0; i < m; i++) {
				matrix[row][i] = matrix[row][i] + 1;
			}
			
			for (int i = 0; i < n; i++) {
				matrix[i][col] = matrix[i][col]  + 1;
			}
                
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] % 2 == 1) {
					count++;
				}
			}
		}

		return count;

	}
	
	public int oddCellsNew(int n, int m, int[][] indices) {
		int[] rows = new int[n];
		int[] cols = new int[m];

		for (int[] index : indices) {
			int row = index[0];
			int col = index[1];

			rows[row] = rows[row] ^ 1;
			cols[col] = cols[col] ^ 1;
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((rows[i] ^ cols[j]) != 0) {
					count++;
				}
			}
		}
		
		return count;
	}

}
