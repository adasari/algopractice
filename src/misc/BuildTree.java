package misc;

public class BuildTree {
	
	private static class TreeNode {
		private char ch;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(char ch) {
			this.ch = ch;
		}
		
	}
	
	private TreeNode construct(char[] preOrder, int preStart, int preEnd, char[] inOrder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		
		char ch = preOrder[preStart];
		
		TreeNode node = new TreeNode(preOrder[preStart]);
		
		int k = 0;
		for (int i = inStart; i < inEnd; i++) {
			if (inOrder[i] == ch) {
				k = i;
			}
		}
		
		node.left = construct(preOrder, preStart+1, preStart+(k-inStart), inOrder, inStart, k-1);
		node.right = construct(preOrder, preStart+(k-inStart)+1, preEnd, inOrder, k+1, inEnd);
		
		return node;
	}

}
