package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        backTracking(root, 0, targetSum, new ArrayList<>(), res);

        return res;
    }

    public void backTracking(TreeNode node, int sum, int target, List<Integer> path, List<List<Integer>> res) {
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                path.add(node.val);
                res.add(path);
            }
            return;
        }

        path.add(node.val);

        if (node.left != null) {
            backTracking(node.left, sum + node.val, target, new ArrayList<>(path), res);
        }

        if (node.right != null) {
            backTracking(node.right, sum + node.val, target, new ArrayList<>(path), res);
        }
    }
}
