package leetcode.leetcode_by_topics.array;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public static void main(String[] args) {
        MaximumErasureValue s = new MaximumErasureValue();
        s.maximumUniqueSubarray(new int[] {5, 2, 1, 2, 5, 2, 1, 2, 5});
    }

    public int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0;

        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        int start = 0;
        int sum = 0;
        int j = 0;
        while (j < n) {
            if (set.contains(nums[j])) {
                maxScore = Math.max(maxScore, sum);
                while (nums[j] != nums[start]) {
                    set.remove(nums[start]);
                    sum -= nums[start];
                    start++;
                }
                set.remove(nums[start]);
                sum -= nums[start];
                start++;
                j = start + set.size();
            }
            else {
                set.add(nums[j]);
                sum += nums[j];
                j++;
            }
        }

        return Math.max(maxScore, sum);
    }
}
