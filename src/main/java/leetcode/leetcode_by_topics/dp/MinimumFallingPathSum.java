package leetcode.leetcode_by_topics.dp;

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = dp[i - 1][j] + matrix[i][j];
                if (j - 1 >= 0) {
                    cur = Math.min(cur, dp[i - 1][j - 1] + matrix[i][j]);
                }
                if (j + 1 < m) {
                    cur = Math.min(cur, dp[i - 1][j + 1] + matrix[i][j]);
                }
                dp[i][j] = cur;
            }
        }

        int res = dp[n - 1][0];
        for (int j = 1; j < m; j++) {
            res = Math.min(dp[n - 1][j], res);
        }

        return res;
    }
}
