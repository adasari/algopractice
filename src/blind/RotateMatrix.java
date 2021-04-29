package blind;

// Rotate Matrix by 90
public class RotateMatrix {
	
	public static void main(String[] args) {
		
	}

	public void rotate(int[][] matrix) {
		// 1. transpose the matrix -> convert rows to columns
		// reverse each row.
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for (int i = 0; i< rows; i++) {
			for (int j = 0; j < cols/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][cols-1-j];
				matrix[i][cols-1-j] = temp;
			}
		}
	}
	
	public void print(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%d ", mat[i][j]);
			}
			
			System.out.println();
		}
	}

}
