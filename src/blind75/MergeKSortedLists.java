package blind75;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeKLists(ListNode[] lists) {
		/*
		ListNode list = lists[0];
		for (int i = 1; i < lists.length; i++) {
			list = merge(list, lists[i]);
		}
		
		return list;
		*/
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (ListNode head : lists) {
			while (head != null) {
				minHeap.add(head.val);
				head = head.next;
			}
		}
		
		ListNode dummy = new ListNode();
		ListNode head = dummy;
		while (minHeap.size() > 0) {
			head.next = new ListNode(minHeap.remove());
		}
		
		return dummy.next;
		
	}

	private ListNode merge(ListNode list, ListNode listNode) {
		ListNode dummy = new ListNode();
		dummy.next = list;
		
		if (list.next != null && listNode.next != null) {
			
		}
		
		return null;
	}

	
	
}
