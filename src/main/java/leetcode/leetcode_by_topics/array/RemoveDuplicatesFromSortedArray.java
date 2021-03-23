package leetcode.leetcode_by_topics.array;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[result] = nums[i];
                result++;
                prev = nums[i];
            }
        }

        return result;
    }
}
