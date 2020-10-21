package leetcode.leetcode_by_topics.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortList {

	public static void main(String[] args) {
		ListNode list = sortList(createLinkedList());
		ListNode node = sortListLessMemory(createLinkedList());
		node.next = null;
	}

	private static ListNode createLinkedList() {
		ListNode n2 = new ListNode(3, null);
		ListNode n3 = new ListNode(1, n2);
		ListNode n4 = new ListNode(2, n3);
		ListNode n5 = new ListNode(4, n4);
		return n5;
	}

	public static ListNode sortList(ListNode head) {
		if(head == null) {
			return head;
		}
		Comparator<ListNode> comparator = Comparator.comparingInt(node -> node.val);
		List<ListNode> list = new ArrayList<>();

		ListNode current = head;
		ListNode node;
		while(current != null) {
			node = current;
			current = current.next;
			node.next = null;
			list.add(node);
		}

		list.sort(comparator);

		for(int i= 0; i < list.size() -1; i++) {
			list.get(i).next = list.get(i+1);
		}

		return list.get(0);
	}

	// sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)
	public static ListNode sortListLessMemory(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		// using two pointers find the middle of the list
		ListNode slow = head;
		ListNode fast = head;
		ListNode prevSlow = null;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prevSlow = slow;
			slow = slow.next;
		}
		ListNode middle = slow;
		prevSlow.next = null;

		// divide step
		ListNode left = sortListLessMemory(head);
		ListNode right = sortListLessMemory(middle);

		// merge step
		return merge(left, right);
	}

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode prevResult = new ListNode();
		ListNode newEnd = prevResult;

		while(left != null && right != null) {
			if(left.val < right.val) {
				newEnd.next = left;
				left = left.next;
				newEnd = newEnd.next;
			} else {
				newEnd.next = right;
				right = right.next;
				newEnd = newEnd.next;
			}
		}

		newEnd.next = left == null ? right : left;

		return prevResult.next;
	}
}
