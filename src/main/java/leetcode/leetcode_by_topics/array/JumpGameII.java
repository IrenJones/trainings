package leetcode.leetcode_by_topics.array;

public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII s = new JumpGameII();
        s.jumpBetter(new int[]{2,3,1,1,4});
    }

    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        dp[0] = 0;
        return helper(nums, dp, nums.length - 1);
    }

    public int helper(int[] nums, Integer[] dp, int i){
        if(dp[i] != null){
            return dp[i];
        }

        int min = Integer.MAX_VALUE;

        for(int j = i - 1; j >= 0; j--){
            if(j + nums[j] >= i){
                min = Math.min(min, 1 + helper(nums, dp, j));
            }
        }
        dp[i] = min;

        return min;
    }

    public int jumpBetter(int[] nums) {
        int count = 0;
        int curEnd = 0;
        int cur = 0;
        for(int i = 0; i < nums.length - 1; i++){
            cur = Math.max(cur, nums[i] + i);
            if(i == curEnd){
                count++;
                curEnd = cur;
            }
        }
        return count;
    }
}
