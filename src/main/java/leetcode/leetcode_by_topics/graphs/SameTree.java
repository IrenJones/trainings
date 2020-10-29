package leetcode.leetcode_by_topics.graphs;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		}

		if(p == null || q == null) {
			return false;
		}

		return helper(p, q);
	}

	public boolean helper(TreeNode p, TreeNode q) {
		if(p.val == q.val) {
			boolean leftResult = true;
			if(p.left == null && q.left != null || p.left != null && q.left == null) {
				leftResult = false;
			} else if (p.left != null && q.left != null){
				leftResult = helper(p.left, q.left);
			}

			boolean rightResult = true;
			if(p.right == null && q.right != null || p.right != null && q.right == null) {
				rightResult = false;
			} else if(p.right != null && q.right != null){
				rightResult = helper(p.right, q.right);
			}
			return leftResult && rightResult;
		} else {
			return false;
		}
	}
}
