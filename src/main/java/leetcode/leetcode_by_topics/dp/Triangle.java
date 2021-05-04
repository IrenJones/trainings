package leetcode.leetcode_by_topics.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        Triangle s = new Triangle();
        Integer[][] arr = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (Integer[] a : arr) {
            triangle.add(Arrays.asList(a));
        }
        s.minimumTotal(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            int m = triangle.get(i).size();
            for (int j = 0; j < m; j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] += dp[i - 1][0];
                } else if (j == m - 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }
}
