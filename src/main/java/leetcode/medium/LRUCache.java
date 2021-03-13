package leetcode.medium;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache obj = new LRUCache(2);
		obj.get(2);
		obj.put(2, 6);
		obj.get(1);
		obj.put(1, 5);
		obj.put(1, 2);
		obj.get(1);
		obj.get(2);

	}

	int capacity;
	PriorityQueue<Element> q;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.q = new PriorityQueue<>(Comparator.comparing(e -> e.time));
	}

	public int get(int key) {
		for(Element e: q){
			if(e.key == key) {
				q.remove(e);
				e.time = LocalDateTime.now();
				q.add(e);
				return e.value;
			}
		}

		return -1;
	}

	public void put(int key, int value) {
		for(Element e: q){
			if(e.key == key) {
				q.remove(e);
				e.value = value;
				e.time = LocalDateTime.now();
				q.add(e);
				return;
			}
		}
		if (q.size() == capacity) {
			q.poll();
		}
		q.add(new Element(value, key, LocalDateTime.now()));
	}

	class Element{
		int key;
		int value;
		LocalDateTime time;

		public Element(int value, int key, LocalDateTime time) {
			this.key = key;
			this.time = time;
			this.value = value;
		}
	}
}

class LRUCacheViaNodes{

	int capacity;
	Node head, tail;
	Map<Integer, Node> map;

	public LRUCacheViaNodes(int capacity) {
		this.capacity = capacity;
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		map = new HashMap<>();
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			addNode(node);
			return node.value;
		}
		return -1;
	}

	private void addNode(Node node) {
		Node tmp = head.next;
		head.next = node;
		node.prev = head;
		node.next = tmp;
		tmp.prev = node;
		map.put(node.key, node);
	}

	private void remove(Node node) {
		map.remove(node.key);
		Node prev = head;
		Node cur = prev.next;
		while (cur != node){
			prev = cur;
			cur = cur.next;
		}

		prev.next = cur.next;
		cur.next.prev = prev;
	}

	public void put(int key, int value) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			addNode(node);
		} else {
			if(map.size() == capacity) {
				remove(tail.prev);
			}
			addNode(new Node(key, value));
		}
	}

	class Node{
		int key;
		int value;
		Node prev;
		Node next;

		public Node(){}

		public Node(int k, int v){
			this.key = k;
			this.value = v;
		}
	}
}
