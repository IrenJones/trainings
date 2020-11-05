package leetcode.leetcode_by_topics.graphs;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.Map;

public class LongestUnivaluePath {

	public static void main(String[] args) {

	}

	int result = 0;

	public int longestUnivaluePath(TreeNode root) {
		helper(root);
		return result;
	}

	private int helper(TreeNode node) {
		if(node == null) {
			return 0;
		}

		int left = helper(node.left);
		int right = helper(node.right);

		int rightH = 0, leftH = 0;

		if(node.left != null && node.left.val == node.val) {
			leftH = left + 1;
		}

		if(node.right != null && node.right.val == node.val) {
			rightH = right + 1;
		}
		result = Math.max(leftH + rightH, result);
		return Math.max(leftH, rightH);
	}
}
