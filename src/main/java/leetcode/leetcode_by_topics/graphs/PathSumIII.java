package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

    int res;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        res = 0;

        dfs(root, 0, targetSum, new ArrayList<>());

        return res;
    }

    public void dfs(TreeNode node, int totalSum, int target, List<Integer> path) {
        if (node == null) {
            return;
        }

        if (path.size() == 0) {
            path.add(node.val);
        }
        else {
            path.add(node.val + path.get(path.size() - 1));

            for (int i = 0; i < path.size() - 1; i++) {
                if (target == path.get(path.size() - 1) - path.get(i)) {
                    res++;
                }
            }
        }

        if (target == totalSum + node.val) {
            res++;
        }

        dfs(node.left, totalSum + node.val, target, new ArrayList<>(path));
        dfs(node.right, totalSum + node.val, target, new ArrayList<>(path));
    }
}
