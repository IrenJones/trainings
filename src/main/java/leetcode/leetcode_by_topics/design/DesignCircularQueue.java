package leetcode.leetcode_by_topics.design;

public class DesignCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4

//        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
//        myCircularQueue.enQueue(1); // return True
//        myCircularQueue.enQueue(2); // return True
//        myCircularQueue.deQueue();
//        myCircularQueue.enQueue(3);
//        myCircularQueue.deQueue();
//        myCircularQueue.enQueue(3);
//        myCircularQueue.deQueue();
//        myCircularQueue.enQueue(3);
//        myCircularQueue.Front();
    }
}

class MyCircularQueue {

    int size;
    int curSize;
    Node head = null;
    Node tail = null;

    public MyCircularQueue(int k) {
        this.size = k;
        this.curSize = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if(head == null && tail == null){
            Node n = new Node(value, null, null);
            head = n;
            tail = n;
        } else {
            Node nT = new Node(value, head, tail);
            head.prev = nT;
            tail.next = nT;
            tail = nT;
        }
        curSize++;
        return true;
    }

    public boolean deQueue() {
        if (curSize != 0) {
            if(curSize == 1){
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            curSize--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (curSize != 0) {
            return head.value;
        }
        return -1;
    }

    public int Rear() {
        if (curSize != 0) {
            return tail.value;
        }
        return -1;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == size;
    }

    class Node{
        int value;
        Node prev;
        Node next;

        public Node(int v, Node n, Node p){
            value = v;
            prev = p;
            next = n;
        }
    }
}
