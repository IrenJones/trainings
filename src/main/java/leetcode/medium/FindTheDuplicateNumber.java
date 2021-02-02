package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[]{1,2,4,3,3,3}));
	}

	public static int findDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for(int value: nums) {
			if(set.contains(value)){
				return value;
			} else {
				set.add(value);
			}
		}

		return -1;
	}

}
