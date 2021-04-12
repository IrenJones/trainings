package leetcode.leetcode_by_topics.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int sum = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                sum += node.val;
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        return sum;
    }
}
