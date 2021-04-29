package educative.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {
	
	private List<Integer> sort(int vertices, int[][] edges) {
		List<Integer> result = new ArrayList<>();
		
		
		Map<Integer, Integer> inDegree = new HashMap<>();
		Map<Integer, List<Integer>> adjacentList = new HashMap<>();
		
		for (int i = 0; i < vertices; i++) {
			inDegree.put(i, 0);
			adjacentList.put(i, new ArrayList<Integer>());
		}
		
		for (int[] edge : edges) {
			int parent = edge[0];
			int child = edge[1];
			adjacentList.get(parent).add(child);
		}
		
		Queue<Integer> sources = new LinkedList<>();
		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0) {
				sources.add(entry.getKey());
			}
		}
		
		while(!sources.isEmpty()) {
			Integer source = sources.poll();
			result.add(source);
			
			List<Integer> children = adjacentList.get(source);
			for (Integer child : children) {
				inDegree.put(child, inDegree.get(child)-1);
				if (inDegree.get(child) == 0) {
					sources.add(child);
				}
			}
		}
		
		if (result.size() != vertices) {
			return new ArrayList<>();
		}
		
		return result;
		
	}

}
