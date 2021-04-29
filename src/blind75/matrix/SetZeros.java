package blind75.matrix;

// 73. Set Matrix Zeroes
public class SetZeros {
	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		boolean firstRowZero = false;
        boolean firstColumnZero = false;
 
        //set first row and column zero or not
        for(int i=0; i<rows; i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }
 
        for(int i=0; i<cols; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		//set first column and row
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
 
        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }
 
	}
}
