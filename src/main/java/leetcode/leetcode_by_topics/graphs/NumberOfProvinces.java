package leetcode.leetcode_by_topics.graphs;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, isConnected);
                count++;
            }
        }

        return count;
    }

    public void dfs(int city, boolean[] visited, int[][] isConnected) {
        if (visited[city]) {
            return;
        }

        visited[city] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1) {
                dfs(i, visited, isConnected);
            }
        }
    }
}
