package misc;

public class Maze {
	
	public static void main(String[] args) {
		long[][] maze = new long[][] {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 1}
		};
		
		System.out.println(new Maze().solution(maze, 3));
	}
	public  boolean solution(long[][] maze, long n) {
		if (maze[0][0] == 1) {
			return false;
		}
		// Type your solution here
		boolean[][] visited = new boolean[(int)n][(int)n];
		return dfs(maze, 0, 0, n, visited);
	}

	public  boolean dfs(long[][] maze, int i, int j, long n, boolean[][] visited) {
		if (i == n-1 && j == n-1) return maze[i][j] != 1;
		
		if (i < 0 || j < 0 || i > n-1 || j > n-1 || visited[i][j] || maze[i][j] == 1) {
			return false;
		}
		
		visited[i][j] = true;
		
		
		
		return dfs(maze, i-1, j, n, visited)
		     || dfs(maze, i+1, j, n, visited)
		     || dfs(maze, i, j+1, n, visited)
		     || dfs(maze, i, j-1, n, visited)
		     ;
	}
	
}
