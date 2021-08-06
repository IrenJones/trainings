package leetcode.leetcode_by_topics.array;

public class OutOfBoundaryPaths {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (n == m && n == 1) {
            return 4;
        }

        int MODULO = 1_000_000_007;

        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int paths = 0;

        for (int move = 0; move < maxMove; move++) {
            int[][] tmp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == n - 1) {
                        paths = (paths + dp[i][j]) % MODULO;
                    }
                    if (j == 0) {
                        paths = (paths + dp[i][j]) % MODULO;
                    }
                    if (i == 0) {
                        paths = (paths + dp[i][j]) % MODULO;
                    }
                    if (i == m - 1) {
                        paths = (paths + dp[i][j]) % MODULO;
                    }

                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int down = i < m - 1 ? dp[i + 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    int right = j < n - 1 ? dp[i][j + 1] : 0;

                    tmp[i][j] = ((up % MODULO + down % MODULO) % MODULO +
                        (left % MODULO + right % MODULO) % MODULO)
                        % MODULO;
                }
            }
            dp = tmp;
        }

        return paths;
    }

    public int findPathsRecursion(int m, int n, int maxMove, int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }

        return findPathsRecursion(m, n, maxMove - 1, i - 1, j)
            + findPathsRecursion(m, n, maxMove - 1, i + 1, j)
            + findPathsRecursion(m, n, maxMove - 1, i, j - 1)
            + findPathsRecursion(m, n, maxMove - 1, i, j + 1);
    }
}
