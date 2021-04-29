package blind75.tree;

public class KthSmallest {
	
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

	public int kthSmallest(TreeNode root, int k) {
		int[] nums = new int[2];
		inorder(root, nums, k);
		return nums[1];
	}
	
	private void inorder(TreeNode node, int[] nums, int k) {
		if (node == null) {
			return;
		}
		
		inorder(node.left, nums, k);
		if (++nums[0] == k) {
			nums[1] = node.val;
			return;
		}
		
		inorder(node.right, nums, k);
	}

}
