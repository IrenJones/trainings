package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CloneGraph {

	public static void main(String[] args) {
		Node result = cloneGraph(create());
		System.out.println(result.val);
	}

	public static Node create() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.neighbors = Arrays.asList(n2, n4);
		n2.neighbors = Arrays.asList(n1, n3);
		n3.neighbors = Arrays.asList(n2, n4);
		n4.neighbors = Arrays.asList(n1, n3);
		return n1;
	}

	public static Node cloneGraph(Node node) {
		if (node == null) {
			return node;
		}
		Map<Integer, Node> values = new HashMap<>();
		return cloneGraph(node, values);
	}

	private static Node cloneGraph(Node node, Map<Integer, Node> values) {
		if (!values.containsKey(node.val)) {
			Node tmp = new Node(node.val);
			values.put(node.val, tmp);
			List<Node> list = new ArrayList<>();
			for (Node v : node.neighbors) {
				Node r = cloneGraph(v, values);
				list.add(r);
			}
			tmp.neighbors = list;
			return tmp;
		}
		return values.get(node.val);
	}
}
