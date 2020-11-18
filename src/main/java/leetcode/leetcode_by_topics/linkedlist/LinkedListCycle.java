package leetcode.leetcode_by_topics.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}

		Set<ListNode> set = new HashSet<>();

		ListNode current = head;
		while(true) {
			if(current == null) {
				return false;
			}
			if(set.contains(current)) {
				return true;
			}
			set.add(current);
			current = current.next;
		}
	}

	public boolean hasCycleTwoPointers(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;
		while(true) {
			if(fast == null || fast.next == null) {
				return false;
			}
			if(fast == slow) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
	}
}
