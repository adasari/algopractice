package blind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

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
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		List<List<Integer>> result = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			List<Integer> row = new ArrayList<Integer>();
			for (int i = 0;  i<n ; i ++) {
				TreeNode c = queue.poll();
				row.add(c.val);
				if (c.left != null) {
					queue.offer(c.left);
				}
				
				if (c.right != null) {
					queue.offer(c.right);
				}
			}
			
			result.add(row);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
	}

}
