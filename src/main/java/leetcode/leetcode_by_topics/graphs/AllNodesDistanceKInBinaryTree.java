package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {

    Map<TreeNode, TreeNode> parents;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        parents = new HashMap<>();
        dfs(root, null);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(target);
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                for (int i = 0; i < size; i++) {
                    list.add(queue.poll().val);
                }
                return list;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                }
                if (parents.get(node) != null && !visited.contains(parents.get(node))) {
                    queue.add(parents.get(node));
                }
            }
            distance++;
        }

        return list;
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        parents.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
