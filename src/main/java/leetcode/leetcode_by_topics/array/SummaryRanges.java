package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		if(nums.length == 1) {
			return Collections.singletonList(String.valueOf(nums[0]));
		}

		int index;
		List<String> list = new ArrayList<>();
		for (int i=0; i< nums.length; i++) {
			StringBuilder s = new StringBuilder();
			s.append(nums[i]);
			index  = i;
			while(index + 1 < nums.length && nums[index] + 1 == nums[index+1]) {
				index++;
			}
			if(i != index) {
				s.append("->").append(nums[index]);
				i = index;
			}
			list.add(s.toString());
		}
		return list;
	}
}
