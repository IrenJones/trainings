package leetcode;

import java.util.Objects;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, null);
        l1.next = new ListNode(4, null);
        l1.next.next = new ListNode(3, null);

        ListNode l2 = new ListNode(5, null);
        l2.next = new ListNode(6, null);
        l2.next.next = new ListNode(4, null);

        //addTwoNumbers(l1, l2);

        l1 = new ListNode(5, null);
        l2 = new ListNode(5, null);

        //addTwoNumbers(l1, l2);

        l1 = new ListNode(0, null);
        l2 = new ListNode(7, null);
        l2.next = new ListNode(3, null);

        //addTwoNumbers(l1, l2);

        l1 = new ListNode(1, null);
        l2 = new ListNode(9, null);
        l2.next = new ListNode(8, null);

        addTwoNumbers(l1, l2);

        l1 = new ListNode(3, null);
        l1.next = new ListNode(7, null);

        l2 = new ListNode(9, null);
        l2.next = new ListNode(2, null);

        //addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String v1 = getValueFromList(l1);
        String v2 = getValueFromList(l2);
        return transformToList(add(v1, v2));
    }

    private static StringBuilder add(String v1, String v2){
        if(v1.length() > v2.length()){
            return addDetailed(v1, v2);
        }
        return addDetailed(v2, v1);
    }


    private static StringBuilder addDetailed(String bigVal, String littleVal) {
        StringBuilder s = new StringBuilder();
        int rem = 0;
        for (int i = 0; i < littleVal.length(); i++) {
            Integer iv1 = Character.digit(bigVal.charAt(i), 10);
            Integer iv2 = Character.digit(littleVal.charAt(i), 10);
            if (rem + iv1 + iv2 >= 10) {
                s.append((rem + iv1 + iv2)%10);
                rem = 1;
            } else {
                s.append(iv1 + iv2 + rem);
                rem = (rem + iv1 + iv2)/10;
            }
        }
        for (int i = littleVal.length(); i < bigVal.length(); i++) {
            int v = Character.digit(bigVal.charAt(i), 10);
            if (rem + v >= 10) {
                s.append((v+1)%10);
                rem = 1;
            } else {
                s.append(v + rem);
                rem = (v + rem)/10;
            }
        }
        if (rem != 0) {
            s.append(rem);
        }
        return s;
    }

    private static ListNode transformToList(StringBuilder s) {
        ListNode result = null;
        ListNode head = null;
        for (int i = 0; i < s.length(); i++) {
            ListNode l = new ListNode(Character.digit(s.charAt(i), 10), null);
            if (result == null) {
                result = l;
                head = l;
            } else {
                result.next = l;
                result = result.next;
            }
        }
        return head;
    }

    private static String getValueFromList(ListNode node) {
        StringBuilder s = new StringBuilder();
        while (Objects.nonNull(node)) {
            s.append(node.val);
            node = node.next;
        }
        return s.toString();
    }
}
