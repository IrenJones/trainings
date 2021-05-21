package leetcode.leetcode_by_topics.graphs;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList s = new FlattenBinaryTreeToLinkedList();
        s.flatten(new TreeNode(1,
            new TreeNode(2,
                new TreeNode(3, null, null),
                new TreeNode(4, null, null)),
            new TreeNode(5,
                null,
                new TreeNode(6, null, null))));
    }

    public void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return;
        }

        helper(root);
    }

    public TreeNode helper(TreeNode node){
        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return node;
        }

        TreeNode leftPart = helper(node.left);
        TreeNode rightPart = helper(node.right);

        node.left = null;
        if(leftPart != null){
            node.right = leftPart;
            TreeNode last = node;
            while(last.right != null){
                last = last.right;
            }
            last.right = rightPart;
        } else{
            node.right = rightPart;
        }

        return node;
    }
}
