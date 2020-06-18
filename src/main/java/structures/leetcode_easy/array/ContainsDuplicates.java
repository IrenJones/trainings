package structures.leetcode_easy.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {
	public boolean containsDuplicate(int[] nums) {
		if(nums.length < 2){
			return false;
		}

		Map<Integer, Integer> map = new HashMap();
		for(int number: nums){
			map.put(number, map.getOrDefault(number, 0) + 1);
			if (map.get(number) > 1){
				return true;
			}
		}
		return false;
	}
}
