package leetcode.leetcode_by_topics.linkedlist;

public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		middleNode(createLinkedList());
	}

	private static ListNode createLinkedList() {
		ListNode n1 = new ListNode(5, null);
		ListNode n2 = new ListNode(4, n1);
		ListNode n3 = new ListNode(3, n2);
		ListNode n4 = new ListNode(2, n3);
		ListNode n5 = new ListNode(1, n4);
		return n5;
	}

	public static ListNode middleNode(ListNode head) {

		ListNode fast = head, slow = head;
		// slow will be in the middle after while cycle
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
}
