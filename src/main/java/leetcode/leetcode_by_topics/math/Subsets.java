package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		subsets(new int[]{1, 2, 3});
	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backTrack(nums, new ArrayList<>(), 0, result);
		return result;
	}

	private static void backTrack(int[] nums, ArrayList<Integer> current, int start, List<List<Integer>> result) {
		result.add(new ArrayList<>(current));
		for(int i = start; i < nums.length; i++){
			current.add(nums[i]);
			backTrack(nums, current, i + 1, result);
			current.remove(current.size() - 1);
		}
	}
}
