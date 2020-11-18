package leetcode.leetcode_by_topics.linkedlist;

import java.util.Stack;

public class AddTwoNumbersII {

	public static void main(String[] args) {

	}

	public ListNode create1 () {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(4, n1);
		ListNode n3 = new ListNode(2, n2);
		ListNode n4 = new ListNode(7, n3);
		return n4;
	}

	public ListNode create2 () {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(6, n1);
		ListNode n3 = new ListNode(5, n2);
		return n3;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			return null;
		}

		if(l1 == null) {
			return l2;
		}

		if(l2 == null) {
			return l1;
		}

		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		while(l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		};
		while(l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		int reminder = 0, result;
		ListNode head = null;
		while (!s1.isEmpty() || !s2.empty()) {
			result = 0;
			result+= s1.isEmpty() ? 0 : s1.pop();
			result+= s2.isEmpty() ? 0 : s2.pop();
			result+=reminder;
			ListNode node = new ListNode(result % 10);
			node.next = head;
			head = node;
			reminder = result / 10;
		}

		if(reminder > 0) {
			ListNode n = new ListNode(reminder);
			n.next = head;
			head = n;
		}

		return head;
	}
}
