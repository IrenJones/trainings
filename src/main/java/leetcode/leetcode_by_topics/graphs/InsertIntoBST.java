package leetcode.leetcode_by_topics.graphs;

public class InsertIntoBST {

	public static void main(String[] args) {
		TreeNode node = insertIntoBST(createTree(), 1);
		int val = node.val;
	}

	private static TreeNode createTree() {
		TreeNode t1 = new TreeNode(15, null, null);
		TreeNode t2 = new TreeNode(14, null, t1);
		TreeNode t3 = new TreeNode(12, null, null);
		TreeNode t4 = new TreeNode(13, t3, t2);
		TreeNode t5 = new TreeNode(7, null, null);
		TreeNode t6 = new TreeNode(6, null, t5);
		TreeNode t7 = new TreeNode(4, null, null);
		TreeNode t8 = new TreeNode(5, t7, t6);
		TreeNode t9 = new TreeNode(10, t8, t4);
		return t9;
	}

	public static TreeNode insertIntoBST(TreeNode root, int val) {
		return insertIntoBST(root, root, val);
	}

	public static TreeNode insertIntoBST(TreeNode root, TreeNode current, int val) {
		if(root == null) {
			return new TreeNode(val, null, null);
		}

		if (current != null && current.left == null && current.val > val) {
			current.left = new TreeNode(val, null, null);
			return root;
		} else if (current != null && current.right == null && current.val < val) {
			current.right = new TreeNode(val, null, null);
			return root;
		} else if (val < current.val) {
			return insertIntoBST(root, current.left, val);
		} else if (current.val < val) {
			return insertIntoBST(root, current.right, val);
		}
		return root;
	}
}
