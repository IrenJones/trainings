package leetcode.easy;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			while (i < nums.length && nums[i] == 0) {
				i++;
			}
			if (i < nums.length) {
				nums[index] = nums[i];
				index++;
			}
		}

		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
