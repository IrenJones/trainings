package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int diff = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            diff += nums[n - i - 1] - nums[i];
        }

        return diff;
    }
}
