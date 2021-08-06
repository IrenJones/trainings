package leetcode.leetcode_by_topics.array;

public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int rightMin = calculateMin(nums, 1);
        int j = 1, n = nums.length;
        while (leftMax > rightMin) {
            leftMax = Math.max(leftMax, nums[j]);
            rightMin = calculateMin(nums, j + 1);
            j++;
        }

        return j;
    }

    public int calculateMin(int[] nums, int i) {
        int res = nums[i];
        for (int j = i + 1; j < nums.length; j++) {
            res = Math.min(res, nums[j]);
        }
        return res;
    }

    public int partitionDisjointFaster(int[] nums) {
        int n = nums.length;

        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                return i + 1;
            }
        }

        return -1;
    }
}
