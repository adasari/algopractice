package blind;

// 572. Subtree of Another Tree
public class SubTree {

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

	public boolean isSubtree(TreeNode s, TreeNode t) {

		if (s == null || t == null) {
			if (s != null || t != null) {
				return false;
			}
		}

		if (s.val == s.val) {
			return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
		} else if (t.val < s.val) {
			return isSubtree(s.left, t);
		}

		return isSubtree(s.right, t);
	}
}
