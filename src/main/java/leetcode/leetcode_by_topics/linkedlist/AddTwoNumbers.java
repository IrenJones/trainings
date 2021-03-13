package leetcode.leetcode_by_topics.linkedlist;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode prev = head;
		int carry = 0;

		while (l1 != null && l2 != null) {
			int v = l1.val + l2.val;
			ListNode node = new ListNode((carry + v) % 10);
			carry = (carry + v) / 10;
			prev.next = node;
			prev = node;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			ListNode node = new ListNode((carry + l1.val) % 10);
			carry = (carry + l1.val) / 10;
			prev.next = node;
			prev = node;
			l1 = l1.next;
		}

		while (l2 != null) {
			ListNode node = new ListNode((carry + l2.val) % 10);
			carry = (carry + l2.val) / 10;
			prev.next = node;
			prev = node;
			l2 = l2.next;
		}

		if (carry > 0) {
			prev.next = new ListNode(carry);
		}

		return head.next;
	}
}
