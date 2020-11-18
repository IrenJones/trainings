package leetcode.leetcode_by_topics.linkedlist;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode current = head;
		ListNode prev = null;
		ListNode newHead = head;
		while (current != null) {
			if (current.val == val) {
				// start
				if (newHead == current) {
					current = current.next;
					newHead = current;
				} else {
					prev.next = current.next;
					current = current.next;
				}
			} else {
				prev = current;
				current = current.next;
			}
		}

		return newHead;
	}
}
