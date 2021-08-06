package leetcode.leetcode_by_topics.array;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        if (nums.length < 2) {
            return true;
        }

        int peaksCount = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                peaksCount++;
            }
            if (peaksCount > 1) {
                return false;
            }
        }
        return true;
    }
}
