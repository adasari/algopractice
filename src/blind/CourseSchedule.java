package blind;

import java.util.ArrayList;

public class CourseSchedule {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] adjList = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int[] pre : prerequisites) {
			adjList[pre[0]].add(pre[1]);
		}

		int[] visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0 && !dfs(adjList, visited, i))
				return false;
		}

		return true;
	}

	private boolean dfs(ArrayList<Integer>[] adjList, int[] visited, int adj) {
		if (visited[adj] == 1)
			return false;
		visited[adj] = 1;

		for (int a : adjList[adj]) {
			if (!dfs(adjList, visited, a))
				return false;
		}

		visited[adj] = 2;

		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new CourseSchedule().canFinish(2,  new int[][] {{1,0}}));
		System.out.println(new CourseSchedule().canFinish(2,  new int[][] {{1,0}, {0, 1}}));
	}
}
