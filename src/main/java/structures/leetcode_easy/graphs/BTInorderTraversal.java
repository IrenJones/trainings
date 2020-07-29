package structures.leetcode_easy.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderTraversal {

	public static void main(String[] args) {
		List<Integer> list = new BTInorderTraversal().inorderTraversal(createTree());
		list.forEach(v -> System.out.print(v + " "));

		System.out.println();

		list = inorderTraversalIterative(createTree());
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

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root != null){
			inOrderTraversalRecursive(root, result);
		}
		return result;
	}

	private void inOrderTraversalRecursive(TreeNode root, List<Integer> result) {
		if(root.left != null){
			inOrderTraversalRecursive(root.left, result);
		}
		result.add(root.val);
		if(root.right != null){
			inOrderTraversalRecursive(root.right, result);
		}
	}


	private static List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack < TreeNode > stack = new Stack < > ();

		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			result.add(node.val);
			node = node.right;
		}
		return result;
	}
}
