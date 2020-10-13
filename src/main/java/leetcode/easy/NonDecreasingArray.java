package leetcode.easy;

public class NonDecreasingArray {
	public static void main(String[] args) {
		//System.out.println(checkPossibility(new int[]{4,2,3}) == true);
		//System.out.println(checkPossibility(new int[]{4,2,1}) == false);
		System.out.println(checkPossibility(new int[]{3,4,2,3}) == false);
	}

	public static boolean checkPossibility(int[] nums) {

		if(nums.length > 0 && nums.length < 3) {
			return true;
		}else {
			int indexOne = -1;

			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i+1]){
					if(indexOne != -1) {
						return false;
					}
					indexOne = i;
				}
			}

			return indexOne <= 0 || indexOne == nums.length - 2 ||
					nums[indexOne-1] <= nums[indexOne+1] ||
					nums[indexOne] <= nums[indexOne + 2];
		}
	}
}
