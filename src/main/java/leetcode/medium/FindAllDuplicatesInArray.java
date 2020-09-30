package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
	public static void main(String[] args) {
		findDuplicates(new int[]{3,4,1,2,1,4, 5,3}).forEach(System.out::println);
	}

	// our array contains values from 1 to n
	public static List<Integer> findDuplicates(int[] nums) {
		// if we need to work with the array containing
		// values appeared more than 2 times (some of them) - use set
		List<Integer> result = new ArrayList<>();
		// we can use this trick only for detecting duplicates (without checking how many times)
		// we don't change elements, we change sign of existing elements in existing array
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			if (nums[index] >= 0) {
				nums[index] = -nums[index];
			} else{
				result.add(Math.abs(index + 1));
			}
		}

		return result;
	}
}
