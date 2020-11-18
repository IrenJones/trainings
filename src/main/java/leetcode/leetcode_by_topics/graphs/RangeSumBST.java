package leetcode.leetcode_by_topics.graphs;

public class RangeSumBST {

	public int rangeSumBST(TreeNode root, int low, int high) {
		if(root == null) {
			return 0;
		}

		int result = 0;

		if(low <= root.val && root.val <= high) {
			result+=root.val;
		}
		if(low < root.val) {
			result+=rangeSumBST(root.left, low, high);
		}

		if(high > root.val) {
			result+=rangeSumBST(root.right, low, high);
		}

		return result;
	}
}
