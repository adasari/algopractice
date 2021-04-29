package blind75.matrix;

public class RotateImage {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
		print(matrix);
		new RotateImage().rotate(matrix);
		print(matrix);
	}

	public void rotate(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length; //  square ?
		
		
		
		
		for (int  i =0 ; i < rows/2; i++) {
			for (int j = 0; j < cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[rows - i-1][j];
				matrix[rows - i - 1][j] = temp;
			}
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
			
			
		}
	}
	
	
	public static void print(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%d ", mat[i][j]);
			}
			
			System.out.println();
		}
		
		System.out.println();
	}

}
