package leetcode.leetcode_by_topics.array;

public class JumpGameVII {

    public static void main(String[] args) {
        JumpGameVII s = new JumpGameVII();
        s.canReachBetter("011010", 2, 3);
    }

    // TLE
    public boolean canReach(String s, int min, int max) {
        char[] nums = s.toCharArray();
        int n = nums.length;
        if (nums[n - 1] != '0') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n - 1; i++) {
            if (dp[i] == true && i + min <= n - 1) {
                for (int j = i + min; j <= i + max && j <= n - 1; j++) {
                    if (nums[j] == '0') {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[n - 1];
    }

    public boolean canReachBetter(String s, int min, int max) {
        char[] nums = s.toCharArray();
        int n = nums.length;
        if(nums[n - 1] != '0'){
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int countOfZerosInWindow = 0;

        for(int i = min; i < n; i++){
            // new element in window
            if(dp[i - min] == true){
                countOfZerosInWindow++;
            }
            // not in window now
            if(i > max && dp[i - max - 1] == true){
                countOfZerosInWindow--;
            }
            dp[i] = countOfZerosInWindow > 0 && nums[i] == '0';
        }

        return dp[n-1];
    }
}
