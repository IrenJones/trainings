package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetsII {

	public static void main(String[] args) {
		subsetsWithDup(new int[]{1, 2, 2});
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(Collections.emptyList());
		if(nums.length == 0) {
			return result;
		}

		Map<String, List<Integer>> map = new HashMap<>();

		for(int size = 1; size <= nums.length; size++) {
			for(int index = 0; index <= nums.length - size; index++) {
				List<Integer> list = new ArrayList<>();
				StringBuilder s = new StringBuilder();
				for(int k = index; k < index + size; k++) {
					list.add(nums[k]);
					s.append(nums[k]);
				}
				if(!map.containsKey(s.toString())) {
					map.put(s.toString(), list);
				}
			}
		}

		for(Map.Entry<String, List<Integer>> e : map.entrySet()) {
			result.add(e.getValue());
		}
		return result;
	}
}
