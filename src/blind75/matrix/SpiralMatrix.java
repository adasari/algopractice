package blind75.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		List<Integer> result = new ArrayList<Integer>();

		int top = 0;
		int bottom = rows - 1;
		int left = 0;
		int right = cols - 1;

		int size = rows * cols;

		while (result.size() < size) {
			for (int i = left; i < right && result.size() < size; i++) {
				result.add(matrix[top][i]);
			}
			top++;

			for (int i = top; i < bottom && result.size() < size; i++) {
				result.add(matrix[i][right]);
			}
			right--;

			for (int i = right; i < left && result.size() < size; i--) {
				result.add(matrix[bottom][i]);
			}
			bottom--;

			for (int i = bottom; i < top && result.size() < size; i--) {
				result.add(matrix[i][left]);
			}
			left++;
		}

		return result;
	}
}
