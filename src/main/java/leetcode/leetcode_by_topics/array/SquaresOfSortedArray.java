package leetcode.leetcode_by_topics.array;

public class SquaresOfSortedArray {
	public int[] sortedSquares(int[] nums) {
		int[] res = new int[nums.length];

		if (nums.length == 0) {
			return res;
		} else if (nums.length == 1) {
			res[0] = nums[0] * nums[0];
			return res;
		}

		int index = 0;
		while (index < nums.length && nums[index] < 0) {
			index++;
		}
		int current = 0;

		int i = index - 1;
		int j = index;

		while (current < nums.length) {
			if (j >= nums.length || i >= 0 && nums[i] * nums[i] < nums[j] * nums[j]) {
				res[current] = nums[i] * nums[i];
				i--;
			} else {
				res[current] = nums[j] * nums[j];
				j++;
			}
			current++;
		}

		return res;
	}

}
