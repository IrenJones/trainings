package leetcode.leetcode_by_topics.array;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        MaxConsecutiveOnesIII s = new MaxConsecutiveOnesIII();
        s.longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }

    public int longestOnes(int[] nums, int k) {
        if (nums.length <= k) {
            return k;
        }

        int cur = k;
        int max = 0;
        int len = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len == 0) {
                start = i;
            }

            if (nums[i] == 1) {
                len++;
            }
            else {
                if (cur > 0) {
                    cur--;
                    len++;
                }
                else if (nums[start] == 1) {
                    while (nums[start] != 0) {
                        start++;
                        len--;
                    }
                    start++;
                }
                else {
                    start++;
                }
            }
            max = Math.max(max, len);
        }

        return max;
    }
}
