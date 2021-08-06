package leetcode.leetcode_by_topics.graphs;

public class MinimumAbsoluteDifferenceBST {

    int minDiff;

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return minDiff;
    }

    public void helper(TreeNode node, int left, int right) {
        if (node == null) {
            return;
        }

        if (left != Integer.MIN_VALUE) {
            minDiff = Math.min(minDiff, node.val - left);
        }

        if (right != Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff, right - node.val);
        }

        helper(node.left, left, node.val);
        helper(node.right, node.val, right);
    }

    // ---------

    int prev;

    public int minDiffInBST(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;
        preorder(root);
        return minDiff;
    }

    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }

        preorder(node.left);

        if (prev != Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff, node.val - prev);
        }

        prev = node.val;

        preorder(node.right);
    }
}
