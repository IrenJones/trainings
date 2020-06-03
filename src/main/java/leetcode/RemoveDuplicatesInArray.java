package leetcode;

public class RemoveDuplicatesInArray {
	public static void main(String[] args) {
		int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		int index = 0;
		for(int j = 1; j< nums.length; j++){
			if(nums[index] != nums[j]){
				index++;
				nums[index] = nums[j];
			}
		}
		return index + 1;
	}
}
