package leetcode.medium;

import edu.princeton.cs.algs4.In;
import sun.reflect.generics.tree.Tree;

import java.util.Map;
import java.util.TreeMap;

public class HouseRobberIII {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4,
				new TreeNode(1,
						new TreeNode(2,
								new TreeNode(3, null, null),
								null
						),
						null
				),
				null);

		System.out.println(rob(root));
	}

	public static int rob(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return root.val;
		}

		return Math.max(robTree(root.left) + robTree(root.right), robTree(root));
	}

	private static int robTree(TreeNode root) {
		if(root == null){
			return 0;
		}

		int result = 0;

		if(root.left != null) {
			result += robTree(root.left.left) + robTree(root.left.right);
		}

		if(root.right != null) {
			result += robTree(root.right.left) + robTree(root.right.right);
		}
		return Math.max(result + root.val, robTree(root.left) + robTree(root.right));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
