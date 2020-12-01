package leetcode.leetcode_by_topics.linkedlist;

public class ReverseLinkedListII {

	public static void main(String[] args) {

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null || m == n) {
			return head;
		}

		ListNode cur = head, prev = null;
		int size = 1;
		while (size < m) {
			prev = cur;
			cur = cur.next;
			size++;
		}

		ListNode start = prev, tail = cur;

		ListNode tmp;
		while (size <= n) {
			tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
			size++;
		}

		if (start != null) {
			start.next = prev;
		} else {
			head = prev;
		}

		tail.next = cur;
		return head;
	}
}
