package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateTargetArrayGivenOrder {

	public static void main(String[] args) {
		createTargetArray(new int[]{1,2,3,4,0}, new int[]{0,1,2,3,0});
	}

	public static int[] createTargetArray(int[] nums, int[] index) {
		List<Integer> list = new LinkedList<>();

		for(int i=0; i< nums.length; i++) {
			if(list.size() == 0) {
				list.add(nums[i]);
			} else{
				list.add(index[i], nums[i]);
			}
		}
		return list.stream()
				.mapToInt(v -> v)
				.toArray();
	}
}
