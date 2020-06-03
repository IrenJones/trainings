package leetcode;

import java.util.Objects;

class MinStack {

	StackNode top;

	private class StackNode {
		int value;
		StackNode prevNode;

		public StackNode(int value, StackNode prevNode) {
			this.value = value;
			this.prevNode = prevNode;
		}
	}

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {
		this.top = null;
	}

	public void push(int x) {
		StackNode node = new StackNode(x, top);
		top = node;
	}

	public void pop() {
		if (top != null) {
			top = top.prevNode;
		}
	}

	public int top() {
		return Objects.isNull(top) ? 0 : top.value;
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		StackNode iterator = top;
		while (iterator != null) {
			if (min > iterator.value) {
				min = iterator.value;
			}
			iterator = iterator.prevNode;
		}
		return min <= Integer.MAX_VALUE ? min : 0;
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
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
