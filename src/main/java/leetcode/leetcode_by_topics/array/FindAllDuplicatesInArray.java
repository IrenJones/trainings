package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

	public static void main(String[] args) {
		findDuplicates(new int[]{1,5,6,3,4,5,8,9,3})
				.forEach(System.out::println);

		System.out.println("---------");
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int index;
		for (int i = 0; i < nums.length; i++) {
			index = Math.abs(nums[i]);
			// elements start from 1, indexes from 0
			if (nums[index - 1] < 0) {
				list.add(Math.abs(index));
			} else {
				nums[index - 1]*= -1;
			}
		}
		return list;
	}
}
