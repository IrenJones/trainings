package leetcode.leetcode_by_topics.linkedlist;


public class SwappingNodesInLinkedList {
	public static void main(String[] args) {
		SwappingNodesInLinkedList list = new SwappingNodesInLinkedList();
		list.swapNodes(new ListNode(1,
				new ListNode(2, null)), 2);
	}

	public ListNode swapNodes(ListNode head, int k) {
		int size = detectSize(head);

		if (size == 1) {
			return head;
		}

		int indexSecond = size - k + 1;
		ListNode cur = head, first = head, second = head;
		for (int i = 1; i <= size; i++) {
			if (i == k) {
				first = cur;
			}
			if (i == indexSecond) {
				second = cur;
			}
			cur = cur.next;
		}

		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;

		return head;
	}

	private int detectSize(ListNode head) {
		int size = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			size++;
		}
		return size;
	}
}
