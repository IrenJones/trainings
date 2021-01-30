package leetcode.leetcode_by_topics.linkedlist;

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		deleteDuplicates(create());
	}

	public static ListNode create(){
//		return new ListNode(1,
//				new ListNode(2,
//						new ListNode(3,
//								new ListNode(3,
//										new ListNode(4, null)))));
		return new ListNode(1, new ListNode(1, null));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode start = new ListNode(-101);
		start.next = head;
		ListNode prev = start;
		ListNode current = start.next;


		while (current != null) {
			if(current.next != null && current.val == current.next.val) {
				while(current.next != null && current.val == current.next.val) {
					current = current.next;
				}
				prev.next = current.next;
			} else {
				prev = prev.next;
			}
			current = current.next;
		}

		return start.next;
	}
}
