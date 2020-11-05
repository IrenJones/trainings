package leetcode.leetcode_by_topics.graphs;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		recoverTreeViaArray(createTree());
	}

	private static TreeNode createTree() {
		TreeNode t1 = new TreeNode(2, null, null);
		TreeNode t2 = new TreeNode(4, t1, null);
		TreeNode t3 = new TreeNode(1, null, null);
		TreeNode t5 = new TreeNode(3, t3, t2);
		return t5;
	}

	public static void recoverTreeViaArray(TreeNode root) {
		List<Integer> arr = new ArrayList<>();

		dfs(root, arr);
		List<Integer> sorted = new ArrayList<>(arr);
		sorted.sort(Integer::compareTo);

		// update
		for (int i=0; i< sorted.size(); i++) {
			if(!sorted.get(i).equals(arr.get(i))){
				update(root, arr.get(i), sorted.get(i));
				break;
			}
		}
	}

	public static void dfs(TreeNode root, List<Integer> arr) {
		if(root.left != null) {
			dfs(root.left, arr);
		}
		arr.add(root.val);
		if(root.right != null) {
			dfs(root.right, arr);
		}
	}

	public static void update(TreeNode root, int from, int to) {

		if(root.left != null ) {
			update(root.left, from, to);
		}

		if(root.val == from) {
			root.val = to;
		} else if (root.val == to) {
			root.val = from;
		}

		if(root.right != null) {
			update(root.right, from, to);
		}
	}

	TreeNode firstWrong = null, middleRoot = null, secondWrong = null, prev = null;

	public void recoverTree(TreeNode root) {

		// find two nodes
		helper(root);

		// fixing
		int tmp;
		if (firstWrong != null && secondWrong != null) {
			tmp = firstWrong.val;
			firstWrong.val = secondWrong.val;
			secondWrong.val = tmp;
		} else if (firstWrong != null && middleRoot != null) {
			tmp = firstWrong.val;
			firstWrong.val = middleRoot.val;
			middleRoot.val = tmp;
		}
	}

	private void helper(TreeNode node) {
		if (node != null) {
			// check left subtree
			helper(node.left);

			// violation of bst rule for root node
			if (prev != null && prev.val > node.val) {
				// first violation
				if (firstWrong == null) {
					firstWrong = prev;
					middleRoot = node;
				} else {
					// second violation
					secondWrong = node;
				}
			}
			prev = node;

			// check right subtree
			helper(node.right);
		}
	}
}
