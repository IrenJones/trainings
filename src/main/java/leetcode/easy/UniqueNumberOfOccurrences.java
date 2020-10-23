package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberOfOccurrences {

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0; i< arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		return map.size() == map.entrySet().stream()
				.map(e -> e.getValue())
				.distinct()
				.count();
	}
}
