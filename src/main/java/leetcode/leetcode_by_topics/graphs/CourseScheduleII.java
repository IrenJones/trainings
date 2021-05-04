package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
    public int[] findOrder(int n, int[][] p) {
        if (p.length == 0) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = i;
            }
            return res;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[n];

        for (int[] link : p) {
            List<Integer> l = graph.getOrDefault(link[1], new ArrayList<>());
            l.add(link[0]);
            graph.put(link[1], l);
            degree[link[0]]++;
        }

        List<Integer> vert = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            if (degree[v] == 0) {
                vert.add(v);
            }
        }

        for (int i = 0; i < vert.size(); i++) {
            if (graph.containsKey(vert.get(i))) {
                for (int node : graph.get(vert.get(i))) {
                    degree[node]--;
                    if (degree[node] == 0)
                        vert.add(node);
                }
            }
        }

        if (vert.size() != n) {
            return new int[0];
        }

        int[] res = new int[n];
        int i = 0;
        for (int v : vert) {
            res[i++] = v;
        }

        return res;
    }
}
