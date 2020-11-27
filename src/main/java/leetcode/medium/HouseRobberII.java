package leetcode.medium;

public class HouseRobberII {

	public static void main(String[] args) {
		System.out.println(rob(new int[]{2, 3, 3}) == 3);
		System.out.println(rob(new int[]{0}) == 0);
		System.out.println(rob(new int[]{1,2,3,1}) == 4);
		System.out.println(rob(new int[]{2, 3, 3}) == 3);
		System.out.println(rob(new int[]{2, 3, 3}) == 3);
	}

	public static int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(rob(nums, 0, nums.length - 1),
				rob(nums, 1, nums.length));
	}

	private static int rob(int[] nums, int start, int end) {
		int includeSum = 0, excludeSum = 0;
		int tmp;
		for (int i = start; i < end; i++) {
			tmp = excludeSum;
			excludeSum = Math.max(excludeSum, includeSum);
			includeSum = tmp + nums[i];
		}
		return Math.max(includeSum, excludeSum);
	}
}
