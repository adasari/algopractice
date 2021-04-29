package blind;

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
		if (root == null)
			return root;

		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		if (root.left != null) {
			root.left = invertTree(root.left);
		}

		if (root.right != null) {
			root.right = invertTree(root.right);
		}

		return root;
	}

}
