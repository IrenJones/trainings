package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();

        dfs(root, new ArrayList<>(), res);

        return res;
    }

    public void dfs(TreeNode node, List<Integer> cur, List<String> res) {
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int val : cur) {
                sb.append(val).append("->");
            }
            sb.append(node.val);
            res.add(sb.toString());
            return;
        }

        if (node.left != null) {
            cur.add(node.val);
            dfs(node.left, new ArrayList<>(cur), res);
            cur.remove(cur.size() - 1);
        }

        if (node.right != null) {
            cur.add(node.val);
            dfs(node.right, new ArrayList<>(cur), res);
            cur.remove(cur.size() - 1);
        }
    }
}
