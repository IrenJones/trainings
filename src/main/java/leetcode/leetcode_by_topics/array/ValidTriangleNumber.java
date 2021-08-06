package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = 2; i < nums.length; i++) {
            int a = 0;
            int b = i - 1;
            while (a < b) {
                if (nums[a] + nums[b] > nums[i]) {
                    count = count + b - a;
                    b--;
                }
                else {
                    a++;
                }
            }
        }

        return count;
    }
}
