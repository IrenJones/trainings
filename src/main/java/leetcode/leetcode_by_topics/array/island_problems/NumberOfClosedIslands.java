package leetcode.leetcode_by_topics.array.island_problems;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (n < 3 || m < 3) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                bfs(grid, i, 0, n, m);
            }
            if (grid[i][m - 1] == 0) {
                bfs(grid, i, m - 1, n, m);
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 0) {
                bfs(grid, 0, j, n, m);
            }
            if (grid[n - 1][j] == 0) {
                bfs(grid, n - 1, j, n, m);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    bfs(grid, i, j, n, m);
                }
            }
        }

        return count;
    }

    public void bfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i == n || j == m || grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1;
        bfs(grid, i + 1, j, n, m);
        bfs(grid, i - 1, j, n, m);
        bfs(grid, i, j - 1, n, m);
        bfs(grid, i, j + 1, n, m);
    }
}
