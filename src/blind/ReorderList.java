package blind;

public class ReorderList {
	private static class ListNode {

		int val;
		ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public void reorderList(ListNode head) {
		// find middle of the element
		// revrse the second half
		// merge 1st half and reversed second half.
	}

}
