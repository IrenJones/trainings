package leetcode.leetcode_by_topics.graphs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreorderAndInorderTraversal {

    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int l, int r, Map<Integer, Integer> map) {
        if(l > r){
            return null;
        }

        TreeNode node = new TreeNode(preorder[index++]);
        int pos = map.get(node.val);
        node.left = helper(preorder, l, pos - 1, map);
        node.right = helper(preorder, pos + 1, r, map);
        return node;
    }
}
