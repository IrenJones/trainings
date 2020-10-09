package leetcode.leetcode_by_topics.linkedlist;

public class RotateList {
	public static void main(String[] args) {
		rotateRight(createLinkedList(), 0);
	}

	private static ListNode createLinkedList() {
		ListNode n1 = new ListNode(5, null);
//		ListNode n2 = new ListNode(4, n1);
//		ListNode n3 = new ListNode(3, n2);
//		ListNode n4 = new ListNode(2, n3);
//		ListNode n5 = new ListNode(1, n4);
		return n1;
	}

	public static ListNode rotateRight(ListNode head, int k) {

		if (head == null || k == 0) {
			return head;
		}
		// get size
		int size = 1;
		ListNode tall = head;
		while(tall.next != null){
			tall = tall.next;
			size++;
		}

		int realShift = size - (size > k? k : k % size);

		if(realShift == size) {
			return head;
		}

		ListNode cur = head;
		while(realShift - 1 > 0) {
			cur = cur.next;
			realShift--;
		}

		ListNode newHead = cur.next;
		cur.next = null;
		tall.next = head;

		return newHead;
	}
}
