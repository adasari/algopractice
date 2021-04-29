package july;

import java.util.LinkedList;
import java.util.Queue;


public class MaxWidthOfBinaryTree {

	private static class NodeInfo {
		private TreeNode node;
		private int pos;
		
		public NodeInfo(TreeNode node, int pos) {
			this.node = node;
			this.pos = pos;
		}

		public TreeNode getNode() {
			return node;
		}

		public int getPos() {
			return pos;
		}

	}
	
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

		public int getVal() {
			return val;
		}

		public TreeNode getLeft() {
			return left;
		}

		public TreeNode getRight() {
			return right;
		}
		
	}
	
	public int widthOfBinaryTree(TreeNode root) {
		int maxWidth = 0;
		
		if (root == null) return maxWidth;
		
		LinkedList<NodeInfo> q = new LinkedList<>();
		q.add(new NodeInfo(root, 0));
		
		while (!q.isEmpty()) {
			int len = q.size();
			maxWidth = Math.max(maxWidth, q.peekLast().getPos() - q.peekFirst().getPos() + 1);
			
			for (int i = 0; i < len; i++) {
				NodeInfo current = q.poll();
				if (current.getNode().getLeft() != null) {
					q.add(new NodeInfo(current.getNode().getLeft(), 2 * current.getPos()));
				}
				
				if (current.getNode().getRight() != null) {
					q.add(new NodeInfo(current.getNode().getRight(), 2 * current.getPos() + 1));
				}
			}
		}
		
		return maxWidth;
	}

}
