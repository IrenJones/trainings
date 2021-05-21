package leetcode.leetcode_by_topics.array;

public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int sum = 0;
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }

        // x * n = sum + m * (n - 1)
        // x - it's min + m

        // min * n + m * n = sum + m *(n - 1)
        // - sum + min * n = m * n - m - m * n
        // m = - min * n + sum
        return sum - min * nums.length;
    }
}
