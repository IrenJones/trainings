package structures.leetcode_easy.others;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = n * (n + 1) / 2;
		int currentSum = 0;
		for (int num : nums) {
			currentSum += num;
		}
		return sum - currentSum;
	}
}
