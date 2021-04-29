package blind;

public class ValidBST {

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

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		boolean valid = true;
		if (root.left != null && root.left.val < root.val) {
			valid &= isValidBST(root.left) ;
		}
		
		if (root.right != null && root.right.val > root.val) {
			valid &= isValidBST(root.right) ;
		}
		
		return valid;
	}

}
