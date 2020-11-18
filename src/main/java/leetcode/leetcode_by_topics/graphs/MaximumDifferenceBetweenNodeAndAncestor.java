package leetcode.leetcode_by_topics.graphs;

public class MaximumDifferenceBetweenNodeAndAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8,
				new TreeNode(3,
						new TreeNode(1),
						new TreeNode(6,
								new TreeNode(4), new TreeNode(7))),
				new TreeNode(10,
						null,
						new TreeNode(14,
								null,
								new TreeNode(13))));

		maxAncestorDiff(root);
	}

	static int result = 0;

	public static int maxAncestorDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}

		helper(root, root.val, root.val);
		return result;
	}

	private static void helper(TreeNode node, int min, int max) {
		if(node != null) {

			int current = Math.max(
					Math.abs(min - node.val),
					Math.abs(max - node.val)
			);

			result = Math.max(result, current);

			min = Math.min(min, node.val);
			max = Math.max(max, node.val);

			helper(node.left, min, max);
			helper(node.right, min, max);
		}
	}
}
