package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
