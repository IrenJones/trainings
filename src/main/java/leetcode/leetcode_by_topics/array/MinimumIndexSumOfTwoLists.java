package leetcode.leetcode_by_topics.array;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();

		for(int i=0; i< list1.length; i++) {
			map.put(list1[i], i);
		}

		int result = Integer.MAX_VALUE;
		for(int i = 0; i< list2.length; i++) {
			if(map.containsKey(list2[i])) {
				int v = map.get(list2[i]) + i;
				map.put(list2[i], -v);
				result = Math.min(result, v);
			}
		}

		int finalResult = result;
		return map.entrySet()
				.stream()
				.filter(e -> e.getValue() == -finalResult)
				.map(Map.Entry::getKey)
				.toArray(String[]:: new);
	}
}
