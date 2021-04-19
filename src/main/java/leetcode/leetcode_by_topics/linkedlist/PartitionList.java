package leetcode.leetcode_by_topics.linkedlist;

public class PartitionList {

    public static void main(String[] args) {
        PartitionList s = new PartitionList();
        s.partition(new ListNode(1,
            new ListNode(2,
                new ListNode(4,
                    new ListNode(3,
                        new ListNode(5,
                            new ListNode(2, null)))))), 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode nodeOne = new ListNode();
        ListNode headOne = nodeOne;
        ListNode nodeTwo = new ListNode();
        ListNode headTwo = nodeTwo;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                nodeOne.next = cur;
                nodeOne = nodeOne.next;
            } else {
                nodeTwo.next = cur;
                nodeTwo = nodeTwo.next;
            }
            cur = cur.next;
        }

        nodeTwo.next = null;
        nodeOne.next = headTwo.next;
        return headOne.next;
    }
}
