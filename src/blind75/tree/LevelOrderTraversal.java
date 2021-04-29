package blind75.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LevelOrderTraversal {
	private static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return null;
		
		List<List<Integer>> result = new ArrayList<>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int n = queue.size();
			List<Integer> currentLevelResult = new ArrayList<>();
			for (int i = 0; i < n; i ++) {
				TreeNode node = queue.poll();
				currentLevelResult.add(node.val);
				
				if (node.left != null) {
					queue.offer(node.left);
				}
				
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			
			result.add(currentLevelResult);
		}
		
		return result;
	}

}
