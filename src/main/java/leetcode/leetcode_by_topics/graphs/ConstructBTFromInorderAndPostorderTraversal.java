package leetcode.leetcode_by_topics.graphs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPostorderTraversal {

    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length - 1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1, map);
    }

    public TreeNode helper(int[] postorder, int l, int r, Map<Integer, Integer> map) {
        if (l > r) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[index--]);
        int pos = map.get(node.val);
        node.right = helper(postorder, pos + 1, r, map);
        node.left = helper(postorder, l, pos - 1, map);

        return node;
    }
}
