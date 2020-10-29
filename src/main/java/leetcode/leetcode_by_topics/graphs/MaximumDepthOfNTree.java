package leetcode.leetcode_by_topics.graphs;

import java.util.Arrays;
import java.util.List;

public class MaximumDepthOfNTree {
	public static void main(String[] args) {
		System.out.println(maxDepth(create()));
	}

	public static Node create(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3, Arrays.asList(n1, n2));
		Node n4 = new Node(4, Arrays.asList(n3));
		Node n5 = new Node(5);
		return new Node(6, Arrays.asList(n5, n4));
	}

	public static int maxDepth(Node root) {
		if(root == null ) {
			return 0;
		} else if(root.children == null || root.children.size() == 0){
			return 1;
		}
		return helper(root);
	}

	private static int helper(Node root) {
		if(root.children == null || root.children.size() == 0) {
			return 1;
		}
		int max = 0;
		for(int i=0; i< root.children.size(); i++) {
			max = Math.max(helper(root.children.get(i)), max);
		}
		return 1 + max;
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
