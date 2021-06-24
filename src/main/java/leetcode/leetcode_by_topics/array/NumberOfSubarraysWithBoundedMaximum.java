package leetcode.leetcode_by_topics.array;

public class NumberOfSubarraysWithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int low = -1;
        int high = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                low = i;
            }
            if (nums[i] >= left) {
                high = i;
            }

            count += high - low;
        }

        return count;
    }

}
