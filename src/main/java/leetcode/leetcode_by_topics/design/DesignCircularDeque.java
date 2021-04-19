package leetcode.leetcode_by_topics.design;

public class DesignCircularDeque {

	public static void main(String[] args) {
		MyCircularDeque s = new MyCircularDeque(7);
		s.insertFront(7);
		s.insertLast(0);
		s.getFront();
		s.insertLast(3);
		s.getFront();
		s.insertFront(9);
		s.getRear();
		s.getFront();
		s.getFront();
		s.deleteLast();
		s.getRear();
	}
}

class MyCircularDeque {

	int capacity;
	int size;
	Node head, tail;

	/**
	 * Initialize your data structure here. Set the size of the deque to be k.
	 */
	public MyCircularDeque(int k) {
		this.capacity = k;
		this.size = 0;
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Adds an item at the front of Deque. Return true if the operation is successful.
	 */
	public boolean insertFront(int value) {
		if(size < capacity) {
			size++;
			Node node = new Node(value);
			Node tmp = head.next;
			head.next = node;
			node.prev = head;
			node.next = tmp;
			tmp .prev = node;
			return true;
		}
		return false;
	}

	/**
	 * Adds an item at the rear of Deque. Return true if the operation is successful.
	 */
	public boolean insertLast(int value) {
		if(size < capacity) {
			size++;
			Node node = new Node(value);
			Node tmp = tail.prev;
			tmp.next = node;
			node.prev = tmp;
			node.next = tail;
			tail.prev = node;
			return true;
		}
		return false;
	}

	/**
	 * Deletes an item from the front of Deque. Return true if the operation is successful.
	 */
	public boolean deleteFront() {
		if(size > 0) {
			size--;
			Node tmp = head.next.next;
			head.next = tmp;
			tmp.prev = head;
			return true;
		}
		return false;
	}

	/**
	 * Deletes an item from the rear of Deque. Return true if the operation is successful.
	 */
	public boolean deleteLast() {
		if(size > 0) {
			size--;
			Node tmp = tail.prev.prev;
			tmp.next = tail;
			tail.prev = tmp;
			return true;
		}

		return false;
	}

	/**
	 * Get the front item from the deque.
	 */
	public int getFront() {
		if(size > 0) {
			return head.next.v;
		}
		return -1;
	}

	/**
	 * Get the last item from the deque.
	 */
	public int getRear() {
		if(size > 0) {
			return tail.prev.v;
		}

		return -1;
	}

	/**
	 * Checks whether the circular deque is empty or not.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Checks whether the circular deque is full or not.
	 */
	public boolean isFull() {
		return size == capacity;
	}

	class Node{
		int v;
		Node prev;
		Node next;

		public Node(){}

		public Node(int v) {
			this.v = v;
		}
	}
}
