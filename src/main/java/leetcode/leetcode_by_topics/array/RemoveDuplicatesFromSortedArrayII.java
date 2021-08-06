package leetcode.leetcode_by_topics.array;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int ind = 1;
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev && count <= 1) {
                nums[ind++] = nums[i];
                count++;
            }
            else if (nums[i] != prev) {
                nums[ind++] = nums[i];
                prev = nums[i];
                count = 1;
            }
        }

        return ind;
    }
}
