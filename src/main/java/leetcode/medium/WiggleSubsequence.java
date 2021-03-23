package leetcode.medium;

public class WiggleSubsequence {

    public static void main(String[] args) {
        WiggleSubsequence s = new WiggleSubsequence();
        s.wiggleMaxLength(new int[] {3, 3, 3, 2, 5});
        WiggleSubsequenceBetter ss = new WiggleSubsequenceBetter();
        ss.wiggleMaxLength(new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        return 1 + Math.max(calculate(nums, 0, -1), calculate(nums, 0, 1));
    }

    private int calculate(int[] nums, int index, int prev) {
        int max = 0;
        for (int i = index + 1; i < nums.length; i++) {
            int v = nums[i] - nums[index];
            if (v != 0 && v * prev <= 0) {
                max = Math.max(max, 1 + calculate(nums, i, v));
            }
        }
        return max;
    }
}

class WiggleSubsequenceBetter {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        int prev = nums[1] - nums[0];
        int count = prev != 0 ? 2 : 1;

        for (int i = 2; i < n; i++) {
            int v = nums[i] - nums[i - 1];
            if (v != 0 && v * prev <= 0) {
                count++;
                prev = v;
            }
        }

        return count;
    }

    public int wiggleMaxLengthAnotherSolution(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            }
            else if (nums[i] - nums[i - 1] < 0) {
                up[i] = up[i - 1];
                down[i] = up[i - 1] + 1;
            }
            else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        return Math.max(up[n - 1], down[n - 1]);
    }
}
