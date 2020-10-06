package leetcode.easy;

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
		List<Integer> subList = new ArrayList<>();
		backTrack(candidates, 0, target, 0, subList, result);
		return result;
	}

	private static void backTrack(int[] candidates, int start, int target, int currentSum,
							   List<Integer> subList, List<List<Integer>> result) {
		if (target - currentSum < 0 ) {
			return;
		} else if (target - currentSum == 0) {
			// add to result
			result.add(new ArrayList<>(subList));
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				subList.add(candidates[i]);
				backTrack(candidates, i, target, currentSum + candidates[i], subList, result);
				subList.remove(subList.size() - 1);
			}
		}
	}
}
