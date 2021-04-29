package lt;

public class TreeDiameter {
	
	class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
	}
	
	int treeDiameter;
	
	private int calculateHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int leftHeight = calculateHeight(node.left);
		int rightHeight = calculateHeight(node.right);
		
		int diameter = leftHeight + rightHeight + 1;
		
		treeDiameter = Math.max(treeDiameter, diameter);
		
		return Math.max(leftHeight, rightHeight) + 1;
		
	}

}
