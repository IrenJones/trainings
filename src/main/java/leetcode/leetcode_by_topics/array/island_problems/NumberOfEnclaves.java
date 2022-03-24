package leetcode.leetcode_by_topics.array.island_problems;

public class NumberOfEnclaves {

    public static void main(String[] args) {
        NumberOfEnclaves solution = new NumberOfEnclaves();

        int[][] arr = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        System.out.println(solution.numEnclaves(arr));
    }

    public int numEnclaves(int[][] A) {
        if (A.length < 2 && A[0].length < 2) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0 || j == 0 || i == A.length - 1 || j == A[i].length - 1) {
                    track(A, i, j);
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    public void track(int a[][], int i, int j) {
        if (i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
            a[i][j] = 0;
            track(a, i + 1, j);
            track(a, i - 1, j);
            track(a, i, j + 1);
            track(a, i, j - 1);
        }
    }


    public int numEnclavesV2(int[][] grid) {
        int cellsCount = 0;

        int n = grid.length;
        int m = grid[0].length;

        if (n < 3 || m < 3) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            bfs(grid, i, 0, n, m);
            bfs(grid, i, m - 1, n, m);
        }
        for (int j = 0; j < m; j++) {
            bfs(grid, 0, j, n, m);
            bfs(grid, n - 1, j, n, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    cellsCount += bfs(grid, i, j, n, m);
                }
            }
        }

        return cellsCount;
    }

    public int bfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        return 1 + bfs(grid, i + 1, j, n, m) + bfs(grid, i - 1, j, n, m) + bfs(grid, i, j - 1, n, m) + bfs(grid, i, j + 1, n, m);
    }
}
