package blind75.tree;

import java.util.HashMap;
import java.util.Map;

// 105. Construct Binary Tree from Preorder and Inorder Traversal
public class BuildTreeFromPreInOrder {

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
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		
		return helper(inorderMap, preorder, 0, 0, inorder.length-1);
	}
	
	private TreeNode helper(Map<Integer, Integer> inorderMap, int[] preorder, int index, int start, int end) {
		if (start > end) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[index]);
		int inIndex = inorderMap.get(preorder[index]);
		
		root.left = helper(inorderMap, preorder, index + 1, start, inIndex-1);
		root.right = helper(inorderMap, preorder, index+ (inIndex - start)+1, inIndex+1, end);
		
		return root;
	}

}
