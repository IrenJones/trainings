package leetcode.medium;

public class HouseRobber {

	public static void main(String[] args) {
		HouseRobber s = new HouseRobber();
		s.rob(new int[]{1, 2, 3, 1});
	}

	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		return Math.max(rob(nums, 0), rob(nums, 1));
	}

	public int rob(int[] nums, int start) {
		int include = 0;
		int exclude = 0;

		for (int i = start; i < nums.length; i++) {
			int tmp = exclude;
			exclude = Math.max(include, exclude);
			include = tmp + nums[i];
		}

		return Math.max(include, exclude);
	}
}
