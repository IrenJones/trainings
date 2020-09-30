package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThanCurrentNumber {
	public static void main(String[] args) {
		smallerNumbersThanCurrent(new int[]{7,7,7,7});
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] result = Arrays.copyOf(nums, nums.length);
		Arrays.sort(result);
		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0; i< nums.length; i++){
			map.putIfAbsent(result[i], i);
		}

		for(int i=0; i< nums.length; i++){
			result[i] = map.get(nums[i]);
		}
		return result;
	}

}
