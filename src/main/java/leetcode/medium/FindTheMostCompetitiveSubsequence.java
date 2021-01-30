package leetcode.medium;

import java.util.Stack;

public class FindTheMostCompetitiveSubsequence {

	public int[] mostCompetitive(int[] nums, int k) {
		if( k == nums.length) {
			return nums;
		}

		Stack<Integer> stack = new Stack<>();
		int countToSkip = nums.length - k;

		for(int element: nums) {

			while(!stack.isEmpty() && countToSkip > 0 && element < stack.peek()) {
				stack.pop();
				countToSkip--;
			}

			stack.push(element);
		}

		while (stack.size() > k) {
			stack.pop();
		}

		int[] res = new int[k];
		for(int i = k-1; i >= 0; i--) {
			res[i] = stack.pop();
		}
		return res;
	}
}
