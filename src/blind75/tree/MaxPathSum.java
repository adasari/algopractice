package blind75.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathSum {
	
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

	public int maxPathSum(TreeNode root) {
		AtomicInteger h = new AtomicInteger(Integer.MIN_VALUE);
		return maxPathSum(root, h);
	}
	
	private int maxPathSum(TreeNode root, AtomicInteger h) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		
		AtomicInteger h1 = new AtomicInteger(Integer.MIN_VALUE);
		AtomicInteger h2 = new AtomicInteger(Integer.MIN_VALUE);
		
		int d1 = maxPathSum(root.left, h1);
		int d2 = maxPathSum(root.right, h2);
		
		h.set(Math.max(Math.max(h1.get(),h2.get()), 0) + root.val);
		
		return Math.max(Math.max(d1, d2), Math.max(h1.get(),  0) + Math.max(h2.get(),  0) + root.val) ;
	}

}
