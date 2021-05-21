package leetcode.leetcode_by_topics.string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        DeleteOperationForTwoStrings s = new DeleteOperationForTwoStrings();
            s.minDistance("mart", "karma");
    }

    public int minDistance(String text1, String text2) {
        if (text1.length() == 0) {
            return text2.length();
        }

        if (text2.length() == 0) {
            return text1.length();
        }

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return n + m - 2 * dp[n][m];
    }
}
