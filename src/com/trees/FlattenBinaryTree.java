package com.trees;

/*
 
 Given a binary tree, flatten the binary tree using inorder traversal. 
 Instead of creating a new list, reuse the nodes,
 where the list is represented by following each right child. As such the root should always 
 be the first element in the list so you do not need to return anything in the implementation, 
 just rearrange the nodes such that following the right child will give us the list.
  

Here's an example and some starter code.

class Node:
  def __init__(self, value, left=None, right=None):
    self.value = value
    self.left = left
    self.right = right

  def __repr__(self):
    return f"({self.value}, {self.left}, {self.right})"

def flatten_bst(root):
  # Fill this in.
  
n5 = Node(5)
n4 = Node(4)
n3 = Node(3, n4)
n2 = Node(2, n5)
n1 = Node(1, n2, n3)

#      1
#    /   \
#   2     3
#  /     /
# 5     4

flatten_bst(n1)
print(n1)

# n1 should now look like
#   1
#    \
#     2
#      \
#       5
#        \
#         3
#          \
#           4
 */
public class FlattenBinaryTree {
	
	public static void main(String[] args) {

		Node n5 = new Node(5);
		Node n4 = new Node(4);
		Node n3 = new Node(3, n4, null);
		Node n2 = new Node(2, n5, null);
		Node n1 = new Node(1, n2, n3);
		
		//System.out.println(numbersSum(n1, 0));
		getFlatten(n1);
		
	}
	
	private static void getFlatten(Node n) {
		if (n == null) {
			return;
		}
		
		Node left = n.getLeft();
		Node right = n.getRight();
		n.left(null);
		
		getFlatten(left);
		getFlatten(right);
		
		n.right(left);
		Node current = n;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		
		current.right(right);
	}

}
