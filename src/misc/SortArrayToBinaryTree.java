package misc;

public class SortArrayToBinaryTree {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };
		Node n = new SortArrayToBinaryTree().build(arr, 0, arr.length - 1);
	}
	
	private Node build(int[] arr, int i, int j) {
		System.out.println(i + " "+ j);
		if (i > j) return null;
		int mid = (i + j)/2;
		Node root = new Node(arr[mid]);
		root.left = build(arr, i, mid - 1);
		root.right = build(arr, mid+1, j);
		return root;
	}

	private static class Node {
		private int val;

		private Node left;
		private Node right;
		
		public Node(int val) {
			this.val = val;
		}
	}
}
