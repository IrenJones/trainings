package leetcode.medium;

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

    // TLE
    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        return Math.max(robTree(root.left) + robTree(root.right), robTree(root));
    }

    private static int robTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;

        if (root.left != null) {
            result += robTree(root.left.left) + robTree(root.left.right);
        }

        if (root.right != null) {
            result += robTree(root.right.left) + robTree(root.right.right);
        }
        return Math.max(result + root.val, robTree(root.left) + robTree(root.right));
    }

    public int robNew(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int include = node.val + left[0] + right[0];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] {exclude, include};
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
