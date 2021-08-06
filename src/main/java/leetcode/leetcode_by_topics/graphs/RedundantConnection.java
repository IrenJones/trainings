package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedundantConnection {

    public static void main(String[] args) {
        RedundantConnection solution = new RedundantConnection();
        int[][] arr = {
            {3, 4},
            {1, 2},
            {2, 4},
            {3, 5},
            {2, 5}
        };
        solution.findRedundantConnection(arr);

    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();

        for (int[] edge : edges) {
            if (nodes.containsKey(edge[0]) && nodes.containsKey(edge[1]) && dfs(nodes, new HashSet<>(), edge[0], edge[1])) {
                return edge;
            }
            List<Integer> list = nodes.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            nodes.put(edge[0], list);
            list = nodes.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            nodes.put(edge[1], list);
        }

        return new int[0];
    }

    public boolean dfs(Map<Integer, List<Integer>> nodes, Set<Integer> visited, int cur, int target) {
        visited.add(cur);
        if (cur == target) {
            return true;
        }

        for (int node : nodes.get(cur)) {
            // avoid going to the prev node
            if (!visited.contains(node) && dfs(nodes, visited, node, target)) {
                return true;
            }
        }

        return false;
    }
}
