package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		permute(new int[]{2, 1, 3});
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backTrack(result, new ArrayList<>(), nums);
		return result;
	}

	private static void backTrack(List<List<Integer>> result, ArrayList<Integer> current, int[] nums) {
		if(current.size() == nums.length) {
			result.add(current);
		} else {
			for(int i = 0; i< nums.length; i++) {
				if(!current.contains(i)) {
					current.add(i);
					backTrack(result, new ArrayList<>(current), nums);
					current.remove(current.size() - 1);
				}
			}
		}
	}
}