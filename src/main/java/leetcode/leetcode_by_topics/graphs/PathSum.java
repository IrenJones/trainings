package leetcode.leetcode_by_topics.graphs;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		return dfs(root, 0, sum);
	}

	public boolean dfs(TreeNode node, int currentSum, int targetSum) {
		int sum = currentSum + node.val;
		if(node.left == null && node.right == null && targetSum == sum) {
			return true;
		}
		boolean result1 = false;
		if(node.left != null) {
			result1 = dfs(node.left, sum, targetSum);
		}

		boolean result2 = false;
		if(node.right != null) {
			result2 = dfs(node.right, sum, targetSum);
		}

		return result1 || result2;
	}
}
