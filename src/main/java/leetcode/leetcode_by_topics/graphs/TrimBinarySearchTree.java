package leetcode.leetcode_by_topics.graphs;

public class TrimBinarySearchTree {

	public static void main(String[] args) {
		TrimBinarySearchTree solution = new TrimBinarySearchTree();
		solution.trimBST(
				new TreeNode(2,
						new TreeNode(1, null, null),
						new TreeNode(3, null, null)),
				3, 4);
	}

	public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root == null) {
			return root;
		}

		if(root.val > high) {
			return trimBST(root.left, low, high);
		}

		if(root.val < low) {
			return trimBST(root.right, low, high);
		}

		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}
}
