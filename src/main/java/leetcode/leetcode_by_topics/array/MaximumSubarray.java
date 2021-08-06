package leetcode.leetcode_by_topics.array;

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray s = new MaximumSubarray();
        s.maxSubArray(new int[]{5,4,-1,7,8});
    }

    public int maxSubArray(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }

        int [] dp = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            dp[i] = dp[i - 1] + nums[i - 1];
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < dp.length; i++){
            for(int j = i+1; j < dp.length; j++){
                max = Math.max(max, dp[j] - dp[i]);
            }
        }
        return max;
    }

    public int maxSubArrayBetter(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }

        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
