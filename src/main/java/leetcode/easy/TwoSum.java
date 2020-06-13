package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int value;
		for(int i=0; i<nums.length; i++){
			value = target - nums[i];
			if(map.containsKey(value)){
				return new int[]{i, map.get(value)};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
