package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

	public static void main(String[] args) {
		LongestHarmoniousSubsequence solution = new LongestHarmoniousSubsequence();
		solution.findLHS(new int[]{6, 5, 4, 1, 1, 2, 5, 6});
	}

	public int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;

		for(int value: nums) {
			map.put(value, map.getOrDefault(value, 0) + 1);
		}

		for(int value: map.keySet()) {
			if (map.containsKey(value + 1)) {
				result = Math.max(result, map.get(value) + map.get(value + 1));
			}
		}

		return result;
	}
}
