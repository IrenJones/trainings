package leetcode.leetcode_by_topics.graphs;

public class BinaryTreeTilt {

	int result = 0;

	public int findTilt(TreeNode root) {
		if(root == null || root.left == null && root.right == null) {
			return 0;
		}
		helper(root);
		return result;
	}

	public int helper(TreeNode node) {
		if(node == null) {
			return 0;
		}

		int left = helper(node.left);
		int right = helper(node.right);

		result += Math.abs(left-right);

		return left + right + node.val;
	}
}
