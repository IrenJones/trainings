package leetcode.leetcode_by_topics.graphs;

public class LowestCommonAncestorOfBT {

	public static void main(String[] args) {
		LowestCommonAncestorOfBT solution = new LowestCommonAncestorOfBT();
		TreeNode node7 = new TreeNode(7, null, null);
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node5 = new TreeNode(5,
				new TreeNode(6, null, null),
				new TreeNode(2, node7, node4));
		TreeNode node10 = new TreeNode(10, null, null);
		TreeNode node1 = new TreeNode(1, node10, null);
		TreeNode root = new TreeNode(3, node5, node1);
		System.out.println(solution.lowestCommonAncestor(root, node4, node7).val);
	}


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left != null && right != null)  {
			return root;
		}
		return left != null
				? left
				: right;
	}
}
