package leetcode.leetcode_by_topics.graphs;

public class ConvertBSTtoGreaterTree {

	public static void main(String[] args) {
		ConvertBSTtoGreaterTree solution = new ConvertBSTtoGreaterTree();
		solution.convertBST(new TreeNode(4,
				new TreeNode(1,
						new TreeNode(0, null, null),
						new TreeNode(2,
								null,
								new TreeNode(3, null, null))),
				new TreeNode(6,
						new TreeNode(5, null, null),
						new TreeNode(7,
								null,
								new TreeNode(8, null, null)))));
	}

	public TreeNode convertBST(TreeNode root) {
		if(root == null || root.left == null && root.right == null) {
			return root;
		}

		helper(root);

		return root;
	}

	int sum = 0;

	private void helper(TreeNode node) {
		if(node == null) {
			return;
		}

		helper(node.right);
		sum += node.val;
		node.val = sum;
		helper(node.left);
	}
}
