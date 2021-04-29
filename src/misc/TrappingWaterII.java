package misc;

import java.util.PriorityQueue;

/*
 * 
 
 Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.
 
 
 
 */


public class TrappingWaterII {
	
	class Cell {
		public int row;
		public int col;
		public int height;
		
		public Cell(int row, int col, int height) {
			this.col = col;
			this.row = row;
			this.height = height;
		}
	}
	
	private int trap(int[][] heights) {
		int M = heights.length;
		int N = heights[0].length;
		
		int result = 0;
		boolean[][] visited = new boolean[M][N];
		PriorityQueue<Cell> heap = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.height, c2.height));
		// add all edge heights.. 
		// add top and bottom rows
		for (int i = 0; i < N; i++) {
			heap.offer(new Cell(0, i, heights[M-1][i]));
			visited[0][i] = true;
			
			heap.offer(new Cell(M-1, i, heights[M-1][i]));
			visited[M-1][i] = true;
		}
		
		// add first and last cols.
		for (int i = 0; i < M; i++) {
			heap.offer(new Cell(i, 0, heights[i][0]));
			visited[i][0] = true;
			
			heap.offer(new Cell(i, N-1, heights[i][N-1]));
			visited[i][N-1] = true;
		}
		
		int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
		
		while (!heap.isEmpty()) {
			Cell cell = heap.poll();
			// neighbors
			for (int[] dir : dirs) {
				int row = cell.row + dir[0];
				int col = cell.col + dir[1];
				int height = cell.height;
				
				if (row >= 0 && row < M && col >= 0 && col < N && !visited[row][col]) {
					visited[row][col] = true;
					result += Math.max(0, height - heights[row][col]);
					heap.offer(new Cell(row, col, Math.max(height, heights[row][col])));
				}
				
				
			}
			
		}
		
		return result;
		
		
	}
}
