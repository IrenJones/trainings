package leetcode.leetcode_by_topics.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode current = head;
		while(current != null) {
			if(!set.contains(current)){
				set.add(current);
			} else {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public ListNode detectCycleConstantMemory(ListNode head) {
		if(head == null || head.next == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				// x1 + x2 + x3 + x2 - the distance fast moved
				// x1 + x2 - the distance slow moved
				// x1 + x2 + x3 + x2 = 2 (x1 + x2) -> x1 = x3
				ListNode slowSecond  = head;
				while(slow != slowSecond) {
					slow = slow.next;
					slowSecond = slowSecond.next;
				}
				return slow;
			}
		}
		return null;
	}
}
