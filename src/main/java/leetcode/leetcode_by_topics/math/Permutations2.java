package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

	public static void main(String[] args) {
		permute(new int[]{1, 1, 3});
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backTrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
		return result;
	}

	private static void backTrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] usedIndexes) {
		if (current.size() == nums.length) {
			result.add(current);
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (usedIndexes[i] == true || i > 0 && usedIndexes[i - 1] == false && nums[i] == nums[i - 1]) {
					continue;
				}
				usedIndexes[i] = true;
				current.add(nums[i]);
				backTrack(result, new ArrayList<>(current), nums, usedIndexes);
				usedIndexes[i] = false;
				current.remove(current.size() - 1);
			}
		}
	}
}
