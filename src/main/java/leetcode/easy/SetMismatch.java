package leetcode.easy;

public class SetMismatch {

	public int[] findErrorNums(int[] nums) {

		int[] values = new int[nums.length + 1];
		int b = 0;

		int currentSum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(values[nums[i]] != 0) {
				b = nums[i];
			}
			values[nums[i]]++;
			currentSum += nums[i];
		}

		int expectedSum = nums.length * (nums.length + 1) / 2;
		// a + b + S = exS , 2b + S = current
		// exS - current = a - b
		// a = exS -current + b
		return new int[]{b, expectedSum - currentSum + b};
	}
}
