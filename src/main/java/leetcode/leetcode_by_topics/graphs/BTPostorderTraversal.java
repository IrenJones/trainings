package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTPostorderTraversal {

	public static void main(String[] args) {
		List<Integer> list = new BTPostorderTraversal().postorderTraversal(createTree());
		list.forEach(v -> System.out.print(v + " "));

		System.out.println();

		list = postorderTraversalIterative(createTree());
		list.forEach(v -> System.out.print(v + " "));
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

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root != null){
			postOrderTraversalRecursive(root, result);
		}
		return result;
	}

	private void postOrderTraversalRecursive(TreeNode root, List<Integer> result) {
		if(root.left != null){
			postOrderTraversalRecursive(root.left, result);
		}
		if(root.right != null){
			postOrderTraversalRecursive(root.right, result);
		}
		result.add(root.val);
	}

	private static List<Integer> postorderTraversalIterative(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			list.addFirst(current.val);
			if (current.left != null) {
				stack.push(current.left);
			}
			if (current.right != null) {
				stack.push(current.right);
			}
		}
		return list;
	}
}
