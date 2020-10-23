package leetcode.leetcode_by_topics.graphs;

public class SecondMinimumNodeInBinaryTree {

	public static void main(String[] args) {
		System.out.println(findSecondMinimumValue(createTree()) == 12);
	}

	private static TreeNode createTree() {
		TreeNode t1 = new TreeNode(15, null, null);
		TreeNode t2 = new TreeNode(14, null, null);
		TreeNode t3 = new TreeNode(12, t2, t1);
		TreeNode t4 = new TreeNode(13, null, null);
		TreeNode t5 = new TreeNode(7, t4, t3);
		return t5;
	}

	public static int findSecondMinimumValue(TreeNode root) {
		if(root == null || root.left == null && root.right == null) {
			return -1;
		}

		int leftMin = root.left.val;
		if (root.left.val == root.val) {
			leftMin = findSecondMinimumValue(root.left);
		}

		int rightMin = root.right.val;
		if (root.right.val == root.val) {
			rightMin = findSecondMinimumValue(root.right);
		}

		if (leftMin != -1 && rightMin != -1) {
			return Math.min(leftMin, rightMin);
		} else if (leftMin != -1) {
			return leftMin;
		} else {
			return rightMin;
		}
	}
}
