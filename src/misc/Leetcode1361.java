package misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Leetcode1361 {
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		
		Map<Integer, Integer> map = new HashMap<>();
		while (!queue.isEmpty()) {
			Integer ele = queue.poll();
		}
		
		return false;
    }

}
