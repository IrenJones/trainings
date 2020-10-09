package leetcode.leetcode_by_topics.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

	public static void main(String[] args) {
		String s = serialize(createTree());
		System.out.println(s);
		TreeNode treeNode = deserialize(s);
		System.out.println(treeNode.val);
	}

	private static TreeNode createTree() {
		TreeNode t1 = new TreeNode(15, null, null);
		TreeNode t2 = new TreeNode(14, null, t1);
		TreeNode t3 = new TreeNode(12, null, null);
		TreeNode t4 = new TreeNode(13, t3, t2);
		TreeNode t5 = new TreeNode(7, null, null);
		TreeNode t6 = new TreeNode(6, null, t5);
		TreeNode t7 = new TreeNode(4, null, null);
		TreeNode t8 = new TreeNode(5, t7, t6);
		TreeNode t9 = new TreeNode(10, t8, t4);
		return t9;
	}

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if(root == null) {
			return "";
		}
		return createString(root, new StringBuilder()).toString();
	}

	public static StringBuilder createString(TreeNode node, StringBuilder s) {
		s.append(node.val).append(" ");
		if(node.left != null) {
			createString(node.left, s);
		} else {
			s.append(-1).append(" ");
		}
		if(node.right != null) {
			createString(node.right, s);
		} else {
			s.append(-1).append(" ");
		}
		return s;
	}


	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if(data == null || data.length() == 0) {
			return null;
		}
		Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(" ")));
		return deserialize(queue);
	}

	public static TreeNode deserialize(Queue<String> queue) {
		if (queue.isEmpty()) {
			return null;
		}
		int value = Integer.parseInt(queue.poll());
		if (value == -1) {
			return null;
		}
		TreeNode root = new TreeNode(value);
		root.left = deserialize(queue);
		root.right = deserialize(queue);
		return root;
	}
}
