package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Dijkstra's Algorithm
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        // times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        new NetworkDelayTime().networkDelayTimeAgain(times, 4, 2);
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

        Map<Integer, Integer> dist = new HashMap();
        for (int node = 1; node <= N; node++) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(K, 0);

        boolean[] visited = new boolean[N + 1];

        while (true) {
            int candidateNode = -1;
            int candidateDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
                if (!visited[i] && dist.get(i) < candidateDist) {
                    candidateDist = dist.get(i);
                    candidateNode = i;
                }
            }

            if (candidateNode < 0) {
                break;
            }

            visited[candidateNode] = true;

            // if we can go to relative nodes
            if (graph.containsKey(candidateNode)) {
                // check each direction
                for (int[] nextNodeInfo : graph.get(candidateNode)) {
                    int distance = dist.get(candidateNode) + nextNodeInfo[1];
                    int optimalDistance = Math.min(dist.get(nextNodeInfo[0]), distance);
                    dist.put(nextNodeInfo[0], optimalDistance);
                }
            }
        }

        int result = 0;
        for (int candidate : dist.values()) {
            if (candidate == Integer.MAX_VALUE) {
                // unreachable node
                return -1;
            }
            result = Math.max(result, candidate);
        }

        return result;
    }

    Map<Integer, Integer> dist;

    public int networkDelayTimeAgain(int[][] times, int n, int k) {
        Integer[][] grid = new Integer[n + 1][n + 1];
        for (int[] time : times) {
            grid[time[0]][time[1]] = time[2];
        }

        dist = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        search(grid, k, n, 0);
        int time = 0;
        for (int v : dist.values()) {
            if (v == Integer.MAX_VALUE) {
                return -1;
            }
            time = Math.max(time, v);
        }

        return time;
    }

    public void search(Integer[][] grid, int node, int n, int cur) {
        if (cur >= dist.get(node)) {
            return;
        }
        dist.put(node, cur);
        for (int i = 1; i <= n; i++) {
            if (grid[node][i] != null) {
                search(grid, i, n, cur + grid[node][i]);
            }
        }
    }
}
