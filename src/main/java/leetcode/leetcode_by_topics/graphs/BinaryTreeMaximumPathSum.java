package leetcode.leetcode_by_topics.graphs;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		maxPathSum(create());
	}

	public static TreeNode create() {
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1, n2, n3);
		return n1;
	}

	static int result = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		helper(root);
		return result;
	}

	private static int helper(TreeNode node) {
		if(node == null) {
			return 0;
		}

		int left = helper(node.left);
		int right = helper(node.right);

		// all possible checks
		result = Math.max(left + right + node.val, result);
		result = Math.max(Math.max(left, right) + node.val, result);
		result = Math.max(node.val, result);

		return Math.max(Math.max(left, right) + node.val, node.val);
	}
}
