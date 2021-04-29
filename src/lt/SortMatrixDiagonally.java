package lt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMatrixDiagonally {
	
	public static void main(String[] args) {
		print(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}});
		//new SortMatrixDiagonally().sortDiagonal(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}}, 0, 0);
		System.out.println();
		print(new SortMatrixDiagonally().diagonalSort(new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}}));
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
	}

	public int[][] diagonalSort(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		
		for (int i = 0; i < rows; i++) {
			sortDiagonal(mat, i, 0);
		}
		
		
		for (int i = 1; i < cols; i++) {
			sortDiagonal(mat, 0, i);
		}
		
		
		return mat;

	}
	
	public void sortDiagonal(int[][] mat, int row, int col) {
		int rows = mat.length;
		int cols = mat[0].length;
		
		int x = row;
		int y = col;
		List<Integer> list = new ArrayList<Integer>();
		
		while ( x < rows && y < cols) {
			list.add(mat[x][y]);
			x++;
			y++;
		}
		
		Collections.sort(list);
		
		x = row;
		y = col;
		int count = 0;
		while (x < rows && y < cols) {
			mat[x][y] = list.get(count++);
			//System.out.printf("%d ", mat[x][y]);
			x++;
			y++;
		}
	}
}
