package leetcode.leetcode_by_topics.graphs;

public class ConstructStringFromBT {

    public static void main(String[] args) {
        TreeNode root = createTree();
        ConstructStringFromBT solution = new ConstructStringFromBT();
        solution.tree2str(root);
    }

    private static TreeNode createTree() {
        return new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        null),
                new TreeNode(3, null, null));
    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        return helper(root).toString();
    }

    public StringBuilder helper(TreeNode root) {
        if (root == null) {
            return new StringBuilder();
        }

        StringBuilder res = new StringBuilder();
        res.append(root.val);

        if (root.left == null && root.right == null) {
            return res;
        }
        res.append("(")
                .append(helper(root.left))
                .append(")");

        StringBuilder right = helper(root.right);

        if (right.length() > 0) {
            res.append("(")
                    .append(right)
                    .append(")");
        }

        return res;
    }


    public String tree2strUgly(TreeNode root) {
        if(root == null){
            return "";
        }

        String res = "" + root.val;

        if(root.left == null && root.right == null){
            return res;
        }
        String right = tree2strUgly(root.right);

        return res + "(" + tree2strUgly(root.left) + ")"
                + (right.equals("") ? "" : "(" + right + ")");
    }
}
