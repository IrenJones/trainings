package leetcode.leetcode_by_topics.array;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int size = removeDuplicates(new int[]{1, 1, 2, 3, 4, 5, 6, 6, 6});
	}
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0){
			return 0;
		}
		int index = 0;
		for(int i=1; i< nums.length; i++){
			if (nums[index] != nums[i]){
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;
	}
}
