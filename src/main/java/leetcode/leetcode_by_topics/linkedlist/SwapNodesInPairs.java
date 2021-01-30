package leetcode.leetcode_by_topics.linkedlist;

import java.util.List;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode res = new ListNode();
		ListNode prev = res, current = head, next;
		while(current != null && current.next != null) {
			prev.next = current.next;
			current.next = current.next.next;
			prev.next.next = current;
			current = current.next;
			prev = prev.next.next;
		}

		return res.next;
	}
}
