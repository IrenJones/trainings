package leetcode.leetcode_by_topics.linkedlist;

public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		ListNode newHead = lists[0];
		for(int i=1; i< lists.length; i++) {
			newHead = mergeTwoLists(newHead, lists[i]);
		}

		return newHead;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode start = new ListNode();
		ListNode tail = start;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}

		if(l1 != null) {
			tail.next = l1;
		}

		if(l2 != null) {
			tail.next = l2;
		}

		return start.next;
	}
}
