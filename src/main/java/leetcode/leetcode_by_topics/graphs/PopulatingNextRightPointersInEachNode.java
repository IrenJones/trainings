package leetcode.leetcode_by_topics.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

	public Node connect(Node root) {
		if(root == null || root.left == null && root.right == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		Node current, prev;
		while (!queue.isEmpty()) {
			int size = queue.size();
			prev = queue.poll();
			if(prev.left != null) {
				queue.add(prev.left);
			}
			if(prev.right != null) {
				queue.add(prev.right);
			}
			for(int i=0; i < size - 1; i++) {
				current = queue.poll();
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
				}
				prev.next = current;
				prev = current;
			}
			prev.next = null;
		}

		return root;
	}

	public void connectRecursive(Node root) {
		if(root != null) {
			if(root.left != null) {
				root.left.next = root.right;

				if(root.next != null) {
					root.right.next = root.next.left;
				}
			}
			connectRecursive(root.left);
			connectRecursive(root.right);
		}
	}


	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
}
