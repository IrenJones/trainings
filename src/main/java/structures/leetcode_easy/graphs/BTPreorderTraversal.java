package structures.leetcode_easy.graphs;

import scala.Int;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BTPreorderTraversal {

	public List<Integer> result;

	public static void main(String[] args) {
		List<Integer> list = new BTPreorderTraversal().preorderTraversal(createTree());
		list.forEach(v -> System.out.print(v + " "));

		System.out.println();

		list = new BTPreorderTraversal().preorderTraversalIterative(createTree());
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

	public List<Integer> preorderTraversal(TreeNode root) {
		result = new ArrayList<>();
		if (root != null){
			preorderTraversalRecursive(root);
		}
		return result;
	}

	public void preorderTraversalRecursive(TreeNode root) {
		result.add(root.val);
		if(root.left != null){
			preorderTraversalRecursive(root.left);
		}
		if(root.right != null){
			preorderTraversalRecursive(root.right);
		}
	}

	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		Stack<TreeNode> stack = new Stack<>();
		if(root != null) {
			stack.push(root);
		}
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			result.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return result;
	}

}
