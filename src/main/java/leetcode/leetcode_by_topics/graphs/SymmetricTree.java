package leetcode.leetcode_by_topics.graphs;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isSymmetric(root, root);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return (left.val == right.val)
				&& isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}

	public boolean isSymmetricIterative(TreeNode root) {
		if(root == null || root.left == null && root.right == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);
		TreeNode left, right;
		while (!queue.isEmpty()) {
			left = queue.poll();
			right = queue.poll();

			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null) {
				return false;
			}
			if (left.val != right.val) {
				return false;
			}

			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;
	}

	public boolean isSymmetricRec(TreeNode root) {
		return helper(root.left, root.right);
	}

	public boolean helper(TreeNode left, TreeNode right){
		if(left == null && right == null){
			return true;
		}
		if(left != null && right != null && left.val == right.val){
			return helper(left.left, right.right) && helper(left.right, right.left);
		}

		return false;
	}
}
