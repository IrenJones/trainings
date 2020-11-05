package leetcode.leetcode_by_topics.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryNumberInLinkedListToInteger {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1, null);
		ListNode n2 = new ListNode(0, n1);
		ListNode n3 = new ListNode(1, n2);

		System.out.println(getDecimalValue(n3) == 5);
	}

	public static int getDecimalValue(ListNode head) {
		List<Integer> list = new ArrayList<>();
		ListNode node = head;
		while(node != null) {
			list.add(node.val);
			node = node.next;
		}

		int result = 0;

		for(int i = list.size() - 1; i >=0; i--) {
			result+= Math.pow(2, i) * list.get(list.size() - 1 - i);
		}

		return result;
	}
}
