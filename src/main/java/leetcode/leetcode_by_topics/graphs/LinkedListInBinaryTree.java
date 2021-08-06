package leetcode.leetcode_by_topics.graphs;

import leetcode.leetcode_by_topics.linkedlist.ListNode;

public class LinkedListInBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.val == head.val) {
            if (pathExist(head, root)) {
                return true;
            }
        }

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean pathExist(ListNode cur, TreeNode node) {
        if (node == null && cur != null) {
            return false;
        }

        if (cur == null) {
            return true;
        }

        return cur.val == node.val && (pathExist(cur.next, node.left) || pathExist(cur.next, node.right));
    }
}
