package leetcode.leetcode_by_topics.linkedlist;

public class RemoveDuplicatesАromSortedList {

    public static void main(String[] args) {
        deleteDuplicatesAgain(create());
    }

    public static ListNode create() {
        return new ListNode(1,
            new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(3)))));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicatesAgain(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int prev = head.val;

        ListNode cur = head.next;
        ListNode prevNode = head;

        while (cur != null) {
            while (cur != null && prev == cur.val) {
                cur = cur.next;
            }

            prevNode.next = cur;
            if (cur != null) {
                prev = cur.val;
                prevNode = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
