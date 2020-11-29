package leetcode.medium;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		canPartitionDP(new int[]{1, 5, 11, 5});
	}

	public boolean canPartition(int[] nums) {

		int fullSum = 0;
		for(int i=0; i< nums.length; i++) {
			fullSum += nums[i];
		}

		if(fullSum % 2 != 0) {
			return false;
		}

		return helper(nums, nums.length - 1, fullSum / 2);
	}

	public boolean helper(int[] nums, int n, int sum){
		if(sum == 0) {
			return true;
		}

		if(n == 0 || sum < 0) {
			return false;
		}

		return helper(nums, n - 1, sum - nums[n - 1]) || helper(nums, n - 1, sum);
	}

	public static boolean canPartitionDP(int[] nums) {

		int fullSum = 0;
		for(int i=0; i< nums.length; i++) {
			fullSum += nums[i];
		}

		if(fullSum % 2 != 0) {
			return false;
		}

		int sum = fullSum / 2;

		boolean [][] dp = new boolean[nums.length + 1][sum + 1];
		dp[0][0] = true;

		for(int i = 1; i <= nums.length; i++) {
			int elementIndex = i - 1;
			for(int currentSum = 0; currentSum <= sum; currentSum++) {
				if(nums[elementIndex] > currentSum) {
					// maybe previous elements can help here
					dp[i][currentSum] = dp[i - 1][currentSum];
				} else {
					// j - nums[elementIndex] = current sum - element = sum without that element
					// current element is less than sum
					dp[i][currentSum] = dp[i - 1][currentSum] || dp[i - 1][currentSum - nums[elementIndex]];
				}
			}
		}

		return dp[nums.length][sum];
	}
}
