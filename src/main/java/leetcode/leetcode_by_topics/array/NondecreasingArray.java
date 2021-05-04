package leetcode.leetcode_by_topics.array;

public class NondecreasingArray {

    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3) {
            return true;
        }

        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (index >= 0) {
                    return false;
                }
                index = i;
            }
        }

        return index <= 0 || index == nums.length - 2
            || nums[index - 1] <= nums[index + 1]
            || nums[index] <= nums[index + 2];
    }
}
