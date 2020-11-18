package leetcode.leetcode_by_topics.linkedlist;

public class RemoveDuplicatesАromSortedList {

	public static void main(String[] args) {
		deleteDuplicates(create());
	}

	public static ListNode create() {
		return new ListNode(1,
				new ListNode(1,
						new ListNode(2,
								new ListNode(3,
										new ListNode(3)))));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return null;
		}

		ListNode current = head;
		while (current != null && current.next != null) {
			if(current.next.val == current.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
}
