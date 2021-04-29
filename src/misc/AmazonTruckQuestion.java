package misc;

public class AmazonTruckQuestion {
	public static void main(String[] args) {
		int[][] grid = {
				{1, 1, 0},
				{0, 0, 0},
				{1, 0, 1},
				{1,1,1}
		};
		
		System.out.println(new AmazonTruckQuestion().countParks(grid));
	}
	
	private int countParks(int[][] grid) {
		int count = 0;
		
		if (grid == null || grid.length == 0) return count;
		
		int rows = grid.length;
		int columns = grid[0].length;
		
		boolean[][] visited = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (!visited[i][j] &&  grid[i][j] == 1) {
					count++;
					dfs(grid, i, j, visited);
				}
			}
		}
		
		return count;
	}

	private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
		if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
			return;
		}
		
		visited[i][j] = true;
		dfs(grid, i+1, j, visited);
		dfs(grid, i-1, j, visited);
		dfs(grid, i, j+1, visited);
		dfs(grid, i, j-1, visited);
	}
}
