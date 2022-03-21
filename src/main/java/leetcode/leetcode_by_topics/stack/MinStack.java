package leetcode.leetcode_by_topics.stack;

public class MinStack {
    Node tail;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        tail = null;
    }

    public void push(int val) {
        Node node = new Node();
        node.value = val;

        if (tail != null) {
            node.min = Math.min(tail.min, val);
        } else {
            node.min = val;
        }

        if (tail != null) {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        } else {
            tail = node;
        }

    }

    public void pop() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }
    }

    public int top() {
        return tail.value;
    }

    public int getMin() {
        return tail.min;
    }

    class Node {
        int min;
        int value;
        Node prev;
        Node next;

        public Node() {
        }
    }
}
