package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
}
