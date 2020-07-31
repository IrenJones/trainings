package leetcode.leetcode_by_topics.linkedlist;

public class DeleteNNode {

	public static void main(String[] args) {
		removeNthFromEnd(createLinkedList(), 2);
	}

	private static ListNode createLinkedList() {
		ListNode n1 = new ListNode(1, null);
		ListNode n2 = new ListNode(2, n1);
		ListNode n3 = new ListNode(3, n2);
		return n3;
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null){
			return null;
		}
		ListNode result = head;
		ListNode current = head;

		int count = 0;

		while(current !=null){
			count++;
			current = current.next;
		}

		// 3 cases
		if(n - count == 0){
			result = head.next;
		} else if(n == 1){
			removeEnd(head, count);
		} else{
			removeMid(head, count - n);
		}

		return result;
	}

	public static void removeMid(ListNode head, int n){
		int size = 0;
		ListNode deleteNode = head;
		while(size < n){
			deleteNode = deleteNode.next;
			size++;
		}
		deleteNode.val = deleteNode.next.val;
		deleteNode.next = deleteNode.next.next;
	}

	public static void removeEnd(ListNode head, int n){
		int size = 0;
		ListNode last = head;
		while(size < n-2){
			last = last.next;
			size++;
		}
		last.next = null;
	}
}
