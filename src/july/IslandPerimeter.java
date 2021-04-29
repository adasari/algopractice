package july;

/*
 You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:

*/

public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},
		                {1,1,1,0},
		                {0,1,0,0},
		                {1,1,0,0}};
		System.out.println(new IslandPerimeter().islandPerimeter(grid));
	}
	
	
	public int islandPerimeter(int[][] grid) {
		if (grid.length == 0) return 0;
		
		int rows = grid.length;
		int columns = grid[0].length;
		
		int perimeter = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == 0) {
					continue;
				}
				
				perimeter += 4;
				
				if (i > 0) perimeter -= grid[i-1][j]; // top boundary
				if (j > 0) perimeter -= grid[i][j-1]; // left boundary
				if (i < rows-1)  perimeter -= grid[i+1][j]; // right boundary
				if (j < columns-1)  perimeter -= grid[i][j+1]; // bottom boundary
			}
		}
		
		return perimeter;
	}
}
