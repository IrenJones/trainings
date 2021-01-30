package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;

public class KthSmallestElementInBST {

	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> nums = inorder(root, new ArrayList<>());
		return nums.get(k - 1);
	}

	public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
		if (root == null) {
			return arr;
		}
		inorder(root.left, arr);
		arr.add(root.val);
		inorder(root.right, arr);
		return arr;
	}
}
