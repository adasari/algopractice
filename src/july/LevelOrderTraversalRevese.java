package july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

*/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

public class LevelOrderTraversalRevese {

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

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        
        Stack<List<Integer>> s = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        List<List<Integer>> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> levelChilds = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode current = q.poll();
                levelChilds.add(current.val);
                
                if (current.left != null) {
                    q.add(current.left);
                }
                
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            
            
            s.push(levelChilds);
        }
        
        while (s.isEmpty()) {
            result.add(s.pop());
        }
        
       
        return result;
        
    }

}
