package leetcode;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		int[] nums = new int[]{2,2,1,2,1,1,1,0,0,2,1,0,2,1,2,2,1,1,1,1,1,0,2,0,2,0,2,2,1,0,2,1,0,2,1,2,0,0,0,0,2,1,1,2,0,1,2,2,0,0,2,2,0,1,0,1,0,0,1,1,1,0,0,2,2,2,1,0,0,2,1,0,1,0,2,2,1,2,1,1,2,1,1,0,0,2,1,0,0};
		sortColors(nums);
		Arrays.stream(nums)
				.forEach(v -> System.out.print(v +" "));
	}

	public static void sortColors(int[] nums) {
		int c1 = 0;
		int c2 = 0;
		for(int i=0; i < nums.length; i++){
			if(nums[i] == 0){
				c1++;
			} else if(nums[i] == 1){
				c2++;
			}
		}

		int index = 0;
		while(c1 > 0){
			nums[index] = 0;
			c1--;
			index++;
		}
		while(c2 > 0){
			nums[index] = 1;
			c2--;
			index++;
		}
		while(index < nums.length){
			nums[index] = 2;
			index++;
		}
	}
}
