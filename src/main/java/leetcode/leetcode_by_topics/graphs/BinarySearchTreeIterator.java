package leetcode.leetcode_by_topics.graphs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		BSTIterator iterator = new BSTIterator(null);

	}
}

class BSTIterator {

	Deque<Integer> deque;

	public BSTIterator(TreeNode root) {
		this.deque = new LinkedList<>();
		fillQueue(deque, root);
	}

	private void fillQueue(Deque<Integer> queue, TreeNode node) {
		if (node == null) {
			return;
		}
		fillQueue(queue, node.left);
		queue.add(node.val);
		fillQueue(queue, node.right);
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		return deque.pollFirst();
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return deque.size() > 0;
	}
}

class BSTIteratorLessMemory {


	Stack<TreeNode> stack;

	public BSTIteratorLessMemory(TreeNode root) {
		this.stack = new Stack<>();
		fillStack(root);
	}

	private void fillStack(TreeNode node) {
		if (node == null) {
			return;
		}
		stack.push(node);
		fillStack(node.left);
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		TreeNode cur = stack.pop();
		if (cur.right != null) {
			fillStack(cur.right);
		}
		return cur.val;
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return stack.size() > 0;
	}
}
