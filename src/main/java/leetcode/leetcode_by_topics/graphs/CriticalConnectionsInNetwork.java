package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CriticalConnectionsInNetwork {

    public static void main(String[] args) {
        CriticalConnectionsInNetwork s = new CriticalConnectionsInNetwork();
        s.criticalConnectionsBetter(4, Arrays.asList(
            Arrays.asList(0,1),
            Arrays.asList(1,2),
            Arrays.asList(2,0),
            Arrays.asList(1,3)));
        s.criticalConnections(4, Arrays.asList(
            Arrays.asList(0,1),
            Arrays.asList(1,2),
            Arrays.asList(2,0),
            Arrays.asList(1,3)));
    }

    // tle
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();

        int[][] m = new int[n][n];

        for (List<Integer> e : connections) {
            int i = e.get(0);
            int j = e.get(1);
            m[i][j] = 1;
            m[j][i] = 1;
        }

        for (List<Integer> e : connections) {
            int i = e.get(0);
            int j = e.get(1);
            m[i][j] = 0;
            m[j][i] = 0;
            boolean[] visited = new boolean[n];
            dfs(m, i, visited);

            for (int k = 0; k < n; k++) {
                if (!visited[k]) {
                    res.add(e);
                    break;
                }
            }

            m[i][j] = 1;
            m[j][i] = 1;
        }

        return res;
    }

    public void dfs(int[][] m, int v, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int vert = q.poll();
                if (!visited[vert]) {
                    visited[vert] = true;
                    for (int j = 0; j < m.length; j++) {
                        if (m[vert][j] == 1 && !visited[j]) {
                            q.add(j);
                        }
                    }
                }
            }
        }
    }

    public List<List<Integer>> criticalConnectionsBetter(int n, List<List<Integer>> connections) {

        List<Integer>[] list = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(List<Integer> e: connections){
            list[e.get(0)].add(e.get(1));
            list[e.get(1)].add(e.get(0));
        }

        Set<List<Integer>> set = new HashSet<>(connections);
        boolean[] visited = new boolean[n];
        int[] rank = new int[n];

        dfs(rank, visited, set, list, 0, 0);

        return new ArrayList<>(set);
    }

    public int dfs(int[] rank, boolean[] visited, Set<List<Integer>> set, List<Integer>[] list, int v, int depth){
        if(visited[v]) {
            return rank[v];
        }

        visited[v] = true;
        rank[v] = depth;
        int curRank = depth;

        for(int nextV: list[v]) {
            if(!visited[nextV] || visited[nextV] && rank[nextV] != depth - 1){
                int r = dfs(rank, visited, set, list, nextV, depth + 1);
                curRank = Math.min(curRank, r);

                // find a circle - remove edges
                if(r <= depth){
                    set.remove(Arrays.asList(v, nextV));
                    set.remove(Arrays.asList(nextV, v));
                }
            }
        }
        return curRank;
    }
}
