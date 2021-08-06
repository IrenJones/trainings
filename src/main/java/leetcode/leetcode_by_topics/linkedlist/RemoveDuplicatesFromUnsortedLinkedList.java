package leetcode.leetcode_by_topics.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedLinkedList {

    public static void main(String[] args) {
        RemoveDuplicatesFromUnsortedLinkedList s = new RemoveDuplicatesFromUnsortedLinkedList();
        s.deleteDuplicates(new ListNode(1,
            new ListNode(1,
                new ListNode(2,
                    new ListNode(3,
                        new ListNode(1))))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode cur = head.next;
        ListNode prev = head;
        Set<Integer> values = new HashSet<>();
        values.add(head.val);

        while(cur != null){
            if(values.contains(cur.val)){
                prev.next = cur.next;
            } else{
                values.add(cur.val);
                prev = cur;
            }

            cur = cur.next;
        }

        return head;
    }
}
