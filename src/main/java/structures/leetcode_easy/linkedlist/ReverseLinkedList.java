package structures.leetcode_easy.linkedlist;

public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode list = createLinkedList();
		ListNode reversed = reverseListIteratively(list);

		ListNode list1 = createLinkedList();
		ListNode reversed1 = reverseListRecursively(list1);
	}

	private static ListNode createLinkedList() {
		ListNode n1 = new ListNode(1, null);
		ListNode n2 = new ListNode(2, n1);
		ListNode n3 = new ListNode(3, n2);
		return n3;
	}

	public static ListNode reverseListRecursively(ListNode head) {
		return null;
	}

	public static ListNode reverseListIteratively(ListNode head) {
		if(head == null){
			return head;
		}
		return null;
	}
}
