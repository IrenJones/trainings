package leetcode;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairs {
	public static void main(String[] args) {
		int[] mas = new int[]{1, 1, 1, 1, 1};
		System.out.println(findPairs(mas, 0));
	}

	public static int findPairs(int[] nums, int k) {
		int count = 0;

		if (nums.length == 0 || k < 0) {
			return count;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (k == 0) {
				if (e.getValue() >= 2) {
					count++;
				}
			} else {
				if (map.containsKey(e.getKey() + k)) {
					count++;
				}
			}
		}
		return count;
	}
}
