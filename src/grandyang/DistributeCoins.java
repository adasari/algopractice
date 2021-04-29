package grandyang;

public class DistributeCoins {
	int moves = 0;
	
	private int distributeCoins(TreeNode root) {
		giveCoins(root);
		return moves;
	}
	
	private int giveCoins(TreeNode node) {
		if (node == null) return 0;
		int left = giveCoins(node.left);
		int right = giveCoins(node.right);
		
		moves = Math.abs(left) + Math.abs(right);
		
		return node.val + left + right - 1;
	}

}


  // Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
