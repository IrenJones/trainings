package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule s = new CourseSchedule();
        int[][] arr = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        s.canFinish(20, arr);
    }

    public boolean canFinish(int n, int[][] p) {
        if (p.length == 0) {
            return true;
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

        return vert.size() == n;
    }
}
