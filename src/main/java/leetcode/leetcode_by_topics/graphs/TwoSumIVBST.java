package leetcode.leetcode_by_topics.graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumIVBST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return false;
    }
}
