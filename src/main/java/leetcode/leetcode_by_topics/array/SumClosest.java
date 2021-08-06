package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 2; i < nums.length && res != 0; i++) {
            int a = 0;
            int b = i - 1;
            while (a < b) {
                int sum = nums[a] + nums[b] + nums[i];
                if (Math.abs(sum - target) < Math.abs(res)) {
                    res = target - sum;
                }
                if (sum > target) {
                    b--;
                }
                else {
                    a++;
                }
            }
        }
        return target - res;
    }
}
