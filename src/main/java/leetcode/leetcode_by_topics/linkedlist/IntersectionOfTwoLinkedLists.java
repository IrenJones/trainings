package leetcode.leetcode_by_topics.linkedlist;

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int sizeA = getSize(headA);
		int sizeB = getSize(headB);

		if(sizeA > sizeB) {
			while (sizeA != sizeB) {
				headA = headA.next;
				sizeA--;
			}
		}

		if(sizeB > sizeA) {
			while (sizeA != sizeB) {
				headB = headB.next;
				sizeB--;
			}
		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}

	private int getSize(ListNode node) {
		int result = 0;
		ListNode cur = node;
		while (cur != null) {
			result++;
			cur = cur.next;
		}
		return result;
	}
}
