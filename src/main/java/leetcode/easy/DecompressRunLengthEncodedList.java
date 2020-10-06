package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {
	public static void main(String[] args) {
		decompressRLElist(new int[]{1,2,3,4});
	}

	public static int[] decompressRLElist(int[] nums) {
		List<Integer> list = new ArrayList<>();

		for(int i=0; i<nums.length -1 ; i+=2){
			for(int j=0; j< nums[i]; j++){
				list.add(nums[i+1]);
			}
		}

		return list.stream()
				.mapToInt(i->i)
				.toArray();
	}
}
