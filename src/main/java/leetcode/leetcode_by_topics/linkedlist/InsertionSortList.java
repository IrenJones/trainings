package leetcode.leetcode_by_topics.linkedlist;

import scala.tools.nsc.matching.ParallelMatching;

import java.util.List;

public class InsertionSortList {

	public static void main(String[] args) {
		insertionSortList(create());
	}

	public static ListNode create(){
		ListNode n1 = new ListNode(1, null);
		ListNode n2 = new ListNode(2, n1);
		ListNode n3 = new ListNode(3, n2);
		ListNode n4 = new ListNode(4, n3);
		return n4;
	}

	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}


		ListNode next, prev, tmp, newHead = null;
		ListNode current = head;
		while(current != null) {
			prev = null;
			next = newHead == null ? null : newHead;

			while(next != null && current.val >= next.val) {
				prev = next;
				next = next.next;
			}

			// remove node from existing list and add to the new one
			tmp = current.next;
			if(prev == null && next == null) {
				newHead = current;
				newHead.next = null;
			} else if(prev == null) {
				newHead = current;
				current.next = next;
			} else {
				prev.next = current;
				current.next = next;
			}
			current = tmp;
		}

		return newHead;
	}
}
