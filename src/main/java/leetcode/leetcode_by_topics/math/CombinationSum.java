package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] arr = {2, 3, 6, 7};
		combinationSum(arr, 7);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		backTrack(candidates, 0, target, 0, new ArrayList<>(), result);
		return result;
	}

	private static void backTrack(int[] candidates, int start, int target, int currentSum,
								  ArrayList<Integer> current, List<List<Integer>> result) {

		if(target < currentSum) {
			return;
		} else if(target == currentSum) {
			result.add(current);
		} else{
			for(int i=start; i < candidates.length; i++) {
				current.add(candidates[i]);
				backTrack(candidates, i, target, currentSum + candidates[i], new ArrayList<>(current), result);
				current.remove(current.size() - 1);
			}
		}
	}
}
