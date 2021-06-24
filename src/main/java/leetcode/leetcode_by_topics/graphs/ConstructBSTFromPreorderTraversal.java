package leetcode.leetcode_by_topics.graphs;

public class ConstructBSTFromPreorderTraversal {

    public static void main(String[] args) {
        ConstructBSTFromPreorderTraversal s = new ConstructBSTFromPreorderTraversal();
        s.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }

    int index;

    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return helper(preorder, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] arr, int max){
        if(index >= arr.length || arr[index] > max){
            return null;
        }

        TreeNode node = new TreeNode(arr[index++]);
        node.left = helper(arr, arr[index - 1]);
        node.right = helper(arr, max);

        return node;
    }
}
