package leetcode.leetcode_by_topics.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        solution.copyRandomList(solution.createList());
    }

    private Node createList() {
        Node n1 = new Node(7);
        n1.random = n1;
        return n1;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> links = new HashMap<>();
        Node headNew = null;
        Node last = null;
        Node cur = head;
        while (cur != null) {
            Node nodeNew = new Node(cur.val);
            if (headNew == null) {
                headNew = nodeNew;
            }
            if (last != null) {
                last.next = nodeNew;
                last = last.next;
            }
            else {
                last = headNew;
            }
            links.put(cur, nodeNew);
            cur = cur.next;
        }

        cur = head;
        Node newCur = headNew;
        while (cur != null) {
            newCur.random = cur.random == null ? null : links.get(cur.random);
            newCur = newCur.next;
            cur = cur.next;
        }

        return headNew;
    }

    public Node copyRandomListBetter(Node head) {
        Node cur = head;

        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        Node newHead = new Node(0);
        Node tail = newHead;
        cur = head;
        while (cur != null) {
            tail.next = cur.next;
            tail = tail.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return newHead.next;
    }
}
