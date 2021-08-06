package leetcode.leetcode_by_topics.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	public static void main(String[] args) {
		LinkedListCycle s = new LinkedListCycle();
		s.hasCycleAgain(create());
	}

	private static ListNode create() {
		ListNode nM = new ListNode(2);
		ListNode node = new ListNode(1, new ListNode(2, new ListNode(4, nM)));
		ListNode nE = new ListNode(2);
		ListNode node3 = new ListNode(1, new ListNode(2, nE));
		nE.next = nM;
		nM.next = node3;
		return node;
	}

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


	public boolean hasCycleAgain(ListNode head) {
		if(head == null || head.next == null){
			return false;
		}

		Set<ListNode> set = new HashSet<>();
		ListNode cur = head;

		while(cur != null){
			if(set.contains(cur)){
				return true;
			}

			set.add(cur);
			cur = cur.next;
		}

		return false;
	}
}
