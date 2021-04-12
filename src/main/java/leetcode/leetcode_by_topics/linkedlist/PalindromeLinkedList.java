package leetcode.leetcode_by_topics.linkedlist;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		System.out.println(isPalindrome(createLinkedList()) == true);
		System.out.println(isPalindromeNotTrueVersion(createLinkedList()) == true);
		System.out.println(isPalindromeTrueVersion(createLinkedList()) == true);

		PalindromeLinkedList s = new PalindromeLinkedList();
		s.isPalindromeRepeat(createLinkedList());
	}

	private static boolean isPalindromeTrueVersion(ListNode head) {

		ListNode fast = head, slow = head;
		// slow will be in the middle after while cycle
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// in the case of odd count of nodes - step forward
		if(fast != null) {
			slow = slow.next;
		}

		// reverse the second part of list
		ListNode newHead = null;
		ListNode next;
		 while(slow != null) {
		 	next = slow.next;
		 	slow.next = newHead;
		 	newHead = slow;
		 	slow = next;
		 }

		 ListNode oldHead = head;

		 while(newHead != null) {
		 	if(newHead.val != oldHead.val) {
		 		return false;
			}
		 	newHead = newHead.next;
		 	oldHead = oldHead.next;
		 }

		return true;
	}

	private static ListNode createLinkedList() {
		ListNode n2 = new ListNode(3, null);
		ListNode n3 = new ListNode(1, n2);
		ListNode n4 = new ListNode(1, n3);
		ListNode n5 = new ListNode(3, n4);
		return n5;
	}

	public static boolean isPalindrome(ListNode head) {
		int size = 0;

		ListNode node = head;
		while (node != null) {
			size++;
			node = node.next;
		}

		int[] n1 = new int[size / 2];

		node = head;
		for (int i = 0; i < n1.length; i++) {
			n1[i] = node.val;
			node = node.next;
		}

		if (size % 2 == 1) {
			node = node.next;
		}

		int index = n1.length - 1;
		while (node != null) {
			if (n1[index] != node.val) {
				return false;
			}
			node = node.next;
			index--;
		}

		return true;
	}

	public static boolean isPalindromeNotTrueVersion(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		int size = 0;
		ListNode node = head;
		while (node != null) {
			size++;
			node = node.next;
		}

		ListNode tmp;
		ListNode pointerHead = new ListNode(-13);
		ListNode pointerTall = head;

		for (int i = 0; i < size/2; i++) {

			tmp = pointerTall;
			pointerTall = pointerTall.next;
			tmp.next = pointerHead;
			pointerHead = tmp;
		}

		if(size % 2 == 1) {
			pointerTall = pointerTall.next;
		}

		while(pointerTall != null) {
			if(pointerHead.val != pointerTall.val) {
				return false;
			}
			pointerHead = pointerHead.next;
			pointerTall = pointerTall.next;
		}

		return true;
	}

	public boolean isPalindromeRepeat(ListNode head) {
		if(head.next == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		if(fast != null) {
			slow = slow.next;
		}

		ListNode reversed = slow;
		ListNode start = head;

		// reverse second part
		ListNode prev = new ListNode(-1);
		while(reversed != null) {
			ListNode tmp = reversed.next;
			reversed.next = prev;
			prev = reversed;
			reversed = tmp;
		}

		reversed = prev;
		while(reversed.val != -1) {
			if(reversed.val != start.val){
				return false;
			}
			reversed = reversed.next;
			start = start.next;
		}

		return true;
	}
}
