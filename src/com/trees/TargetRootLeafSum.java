package com.trees;

/*
Given a binary tree, and a target number, find if there is a path from the root to any leaf that sums up to the target.

Here's an example and some starter code.

class Node:
  def __init__(self, value, left=None, right=None):
    self.value = value
    self.left = left
    self.right = right

def target_sum_bst(root, target):
  # Fill this in.

#      1
#    /   \
#   2     3
#    \     \
#     6     4
n6 = Node(6)
n4 = Node(4)
n3 = Node(3, None, n4)
n2 = Node(2, None, n6)
n1 = Node(1, n2, n3)

print(target_sum_bst(n1, 9))
# True
# Path from 1 -> 2 -> 6
 */

public class TargetRootLeafSum {
	
	public static void main(String[] args) {

		Node n6 = new Node(6);
		Node n4 = new Node(4);
		Node n3 = new Node(3, null, n4);
		Node n2 = new Node(2, null, n6);
		Node n1 = new Node(1, n2, n3);
		
		System.out.println(exists(n1, 0, 9));
	}

	private static boolean exists(Node root, int sum, int taget) {
		if (root == null) {
			return false;
		}
		
		sum = sum + root.getData();
		if (sum == taget) {
			return true;
		}else if (root.getLeft() != null) {
			return exists(root.getLeft(), sum, taget);
		} else if (root.getRight() != null) {
			return exists(root.getRight(), sum, taget);
		}
		
		return false;
	}
	
}
