package leetcode.easy;

public class MinStack {
    public static void main(String[] args) {
        MinStackk stack = new MinStackk();
        stack.push(3);
        stack.push(3);
        stack.push(6);
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.top());

        MinStackk obj = new MinStackk();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-2147483648);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

class MinStackk {

    private Node top;
    private int min;

    public MinStackk() {
        top = null;
    }

    public void push(int x) {
        Node node;
        if (top == null) {
            node = new Node(null, x);
            this.min = x;
        }
        else {
            node = new Node(top, x);
            if (x < this.min) {
                this.min = x;
            }
        }
        this.top = node;
    }

    public void pop() {
        this.top = this.top.prev;
        int min = Integer.MAX_VALUE;

        // update min value
        Node cur = this.top;
        while (cur != null) {
            if (cur.value < min) {
                min = cur.value;
            }
            cur = cur.prev;
        }
        this.min = min <= Integer.MAX_VALUE ? min : 0;
    }

    public int top() {
        return this.top.value;
    }

    public int getMin() {
        return this.min;
    }

    class Node {
        Node prev;
        int value;

        public Node() {
        }

        public Node(Node p, int v) {
            this.prev = p;
            this.value = v;
        }
    }
}

class MinStackAgain {

    class Node {
        int val;
        Node prev;

        public Node(int v, Node p) {
            val = v;
            prev = p;
        }

        public Node() {
        }
    }

    Node head;
    Node tail;
    int minValue;

    /**
     * initialize your data structure here.
     */
    public MinStackAgain() {
        minValue = Integer.MAX_VALUE;
        head = new Node();
        tail = head;
    }

    public void push(int val) {
        Node node = new Node(val, tail);
        tail = node;
        if (minValue > val) {
            minValue = val;
        }
    }

    public void pop() {
        int tailValue = tail.val;
        tail = tail.prev;
        Node cur = tail;
        if (head == tail) {
            minValue = Integer.MAX_VALUE;
        }

        if (tailValue == minValue) {
            minValue = tail.val;
            while (cur != head) {
                minValue = Math.min(minValue, cur.val);
                cur = cur.prev;
            }
        }
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return minValue;
    }
}


