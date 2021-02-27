package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray solution = new ShortestUnsortedContinuousSubarray();
		solution.findUnsortedSubarrayStack(new int[]{2, 2, 2, 1, 1, 9, 15});
	}

	public int findUnsortedSubarray(int[] nums) {
		int[] res = Arrays.copyOf(nums, nums.length);
		Arrays.sort(res);

		int start = 0;
		int end = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (res[i] != nums[i]) {
				start = i;
				while (i <= end && res[end] == nums[end]) {
					end--;
				}

				return end - start + 1;
			}
		}

		return 0;
	}

	public int findUnsortedSubarrayStack(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int start = nums.length, end = -1;

		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				start = Math.min(start, stack.pop());
			}
			stack.push(i);
		}

		stack.clear();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				end = Math.max(end, stack.pop());
			}
			stack.push(i);
		}

		return end - start > 0
				? end - start + 1
				: 0;
	}
}
