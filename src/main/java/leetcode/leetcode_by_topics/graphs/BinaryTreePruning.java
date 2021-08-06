package leetcode.leetcode_by_topics.graphs;

public class BinaryTreePruning {

    public static void main(String[] args) {
        BinaryTreePruning s = new BinaryTreePruning();
        s.pruneTree(createTree());
    }

    private static TreeNode createTree() {
        TreeNode t0 = new TreeNode(0, null, null);
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t2 = new TreeNode(0, null, null);
        TreeNode t3 = new TreeNode(1, null, null);
        TreeNode t4 = new TreeNode(1, t0, null);
        TreeNode t5 = new TreeNode(0, t2, t1);
        TreeNode t6 = new TreeNode(1, t4, t3);
        TreeNode t7 = new TreeNode(1, t6, t5);
        return t7;
    }

    public TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }

    public TreeNode prune(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = prune(node.left);
        TreeNode right = prune(node.right);

        if (left == null && right == null) {
            node.left = left;
            node.right = right;
            return node.val == 1 ? node : null;
        }

        node.left = left;
        node.right = right;
        return node;
    }
}
