package leetcode.leetcode_by_topics.graphs;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		System.out.println(isBalanced(createTree()) == false);
	}

	private static TreeNode createTree() {
		TreeNode t1 = new TreeNode(15, null, null);
		TreeNode t2 = new TreeNode(14, null, null);
		TreeNode t3 = new TreeNode(12, t2, t1);
		//TreeNode t4 = new TreeNode(13, null, null);
		TreeNode t5 = new TreeNode(7, null, t3);
		return t5;
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return true;
		}

		return isBalanced(root.right) &&
				isBalanced(root.left) &&
				Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
	}

	public static int maxDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}
}
