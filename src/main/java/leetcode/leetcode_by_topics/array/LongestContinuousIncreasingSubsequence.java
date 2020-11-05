package leetcode.leetcode_by_topics.array;

public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(findLengthOfLCIS(new int[]{1, 3, 4, 5, 4, 7}) == 4);
	}

	public static int findLengthOfLCIS(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}

		int maxLen = 1;
		int current = 1;
		for (int i = 0; i < nums.length; i++) {
			if(i > 0 && nums[i-1] < nums[i]) {
				current++;
			} else{
				current = 1;
			}
			maxLen = Math.max(current, maxLen);
		}
		return maxLen;
	}
}
