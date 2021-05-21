package leetcode.leetcode_by_topics.graphs;

import leetcode.leetcode_by_topics.linkedlist.ListNode;

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return bst(head, null);
    }

    public TreeNode bst(ListNode head, ListNode end) {

        if (head == end) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode localHead = new TreeNode(slow.val);
        localHead.left = bst(head, slow);
        localHead.right = bst(slow.next, end);
        return localHead;
    }
}
