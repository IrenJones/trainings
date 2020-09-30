package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

	public static void main(String[] args) {
		System.out.println(numIdenticalPairs(new int[]{1,2,3,1,1,3}));
	}

	public static int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0; i< nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		int result = 0;
		for(Map.Entry<Integer, Integer> value: map.entrySet()){
			result+=calculateSum(value.getValue());
		}
		return result;
	}

	private static int calculateSum(Integer value) {
		return value*(value-1)/2;
	}
}
