package leetcode.leetcode_by_topics.linkedlist;

import java.util.List;

public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode list = createLinkedList();
		ListNode reversed = reverseListIteratively(list);

		ListNode list1 = createLinkedList();
		ListNode reversed1 = reverseList(list1);
	}

	private static ListNode createLinkedList() {
		ListNode n1 = new ListNode(1, null);
		ListNode n2 = new ListNode(2, n1);
		ListNode n3 = new ListNode(3, n2);
		return n3;
	}

	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode prev = reverseList(head.next);
		head.next = null;
		return prev;
	}

	public static ListNode reverseListIteratively(ListNode head) {
		if(head == null){
			return head;
		}

		ListNode prev = head;
		ListNode current  = prev.next;
		prev.next = null;
		ListNode tmp;
		while(current != null) {
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}

		return prev;
	}
}
