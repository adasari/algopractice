package misc;

import java.util.ArrayList;
import java.util.List;

public class AllPathsInGraph {

	public static void main(String[] args) {
		List<List<Integer>> paths = new AllPathsInGraph().allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
		paths = new AllPathsInGraph().allPathsSourceTarget(new int[][]{{1,3},{2},{3},{}});
		System.out.println();
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<>(); 
		path.add(0);
		dfs(graph, result, path, 0);
		return result;
	}

	
	private void dfs(int[][] graph, List<List<Integer>> result, List<Integer> path, int index) {
		int[] adjacents = graph[index];
		if (null == adjacents || adjacents.length == 0) {
			result.add(path);
			return;
		}
		
		for (int adj : adjacents) {
			List<Integer> newPath = new ArrayList<Integer>(path);
			newPath.add(adj);
			dfs(graph, result, newPath, adj);
		}
	}
}

