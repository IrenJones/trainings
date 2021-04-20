package leetcode.leetcode_by_topics.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CombinationSumIV {

    public static void main(String[] args) {
        CombinationSumIV s = new CombinationSumIV();
        s.combinationSum4(new int[] {1, 2}, 10);
        s.combinationSum4(new int[] {1, 2, 3}, 4);
    }

    // TLE
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        int max = Math.max(nums[nums.length - 1] + 1, target + 1);

        int[] count = new int[max];

        Set<Integer> set = new HashSet<>();
        for (int v : nums) {
            set.add(v);
        }

        count[target] = combinations(count, target, nums, set);

        return count[target];
    }

    public int combinations(int[] count, int sum, int[] nums, Set<Integer> set) {
        if (count[sum] >= 1) {
            return count[sum];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] > 0) {
                res += combinations(count, sum - nums[i], nums, set);
            }
        }
        if (set.contains(sum)) {
            res++;
        }
        count[sum] = res;
        return res;
    }

    // better
    public int combinationSum4Better(int[] nums, int target) {
        int[] count = new int[target + 1];
        Arrays.fill(count, -1);
        count[0] = 1;
        return combinations(count, target, nums);
    }

    public int combinations(int[] count, int sum, int[] nums) {
        if (count[sum] != -1) {
            return count[sum];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum >= nums[i]) {
                res += combinations(count, sum - nums[i], nums);
            }
        }

        count[sum] = res;
        return res;
    }

}
