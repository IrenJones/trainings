package leetcode.leetcode_by_topics.linkedlist;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode cur = newHead;
        ListNode curLate = newHead;
        ListNode prev = newHead;

        int i = 0;
        while (cur != null) {
            if (i >= n) {
                prev = curLate;
                curLate = curLate.next;
            }
            cur = cur.next;
            i++;
        }

        prev.next = curLate.next;
        return newHead.next;
    }
}
