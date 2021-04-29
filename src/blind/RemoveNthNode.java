package blind;

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
  
 

public class RemoveNthNode {
	
	public static void main(String[] args) {
		// 1->2->3->4->5
		ListNode five = new ListNode(5);
		ListNode four = new ListNode(4, five);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(2, three);
		ListNode head = new ListNode(1, two);
		
		print(new RemoveNthNode().removeNthFromEnd(head, 2));
		
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (n > 0) {
			fast = fast.next;
			n--;
		}
		
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;
		
		return dummyNode.next;
	}
	
	private static void print(ListNode head) {
		while (head != null) {
			System.out.printf("%d ", head.val);
			head = head.next;
		}
		
	}

}
