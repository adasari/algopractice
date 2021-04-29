package blind;



public class MergeTwoSortedLists {
	
	class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode dummy = new ListNode(0);
		ListNode l3 = dummy;

		while (l1.next != null || l2.next != null) {
			if (l1.val <= l2.val) {
				l3.next = l1;
				l1 = l1.next;
			} else {
				l3.next = l2;
				l2 = l2.next;
			}

			l3 = l3.next;
		}

		if (l1 != null) {
			l3.next = l1;

		}

		if (l2 != null) {
			l3.next = l2;
		}

		return dummy.next;
	}

}
