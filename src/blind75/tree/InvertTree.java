package blind75.tree;

public class InvertTree {

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

	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		root.left = invertTree(right);
		root.right = invertTree(left);
		
		return root;
	}

}
