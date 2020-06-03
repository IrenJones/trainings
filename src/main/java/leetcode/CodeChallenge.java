package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CodeChallenge {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{2, 2, 1, 3, 3}));
	}

	// Given a non-empty array of integers, every element appears twice except for one. 
	// Find that single one. Solution should have linear runtime complexity
	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int value: nums){
			map.put(value, map.getOrDefault(value, 0) + 1);
		}

		return map.entrySet().stream()
				.filter(e -> e.getValue() == 1)
				.map(Map.Entry::getKey)
				.findFirst().get();
	}
}
