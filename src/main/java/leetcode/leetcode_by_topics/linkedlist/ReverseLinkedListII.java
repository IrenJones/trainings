package leetcode.leetcode_by_topics.linkedlist;

public class ReverseLinkedListII {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
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
        }
        else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

    public ListNode reverseBetweenAgain(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prev = newHead;
        ListNode cur = newHead;
        int index = 0;

        while (index < left) {
            prev = cur;
            cur = cur.next;
            index++;
        }

        ListNode tmp;
        ListNode start = prev, tail = cur;
        while (index <= right) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            index++;
        }

        start.next = prev;
        tail.next = cur;

        return newHead.next;
    }
}
