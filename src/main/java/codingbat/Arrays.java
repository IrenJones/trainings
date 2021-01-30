package codingbat;

public class Arrays {

	public int maxSpan(int[] nums) {
		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			int j = nums.length - 1;

			while (nums[i] != nums[j]) {
				j--;
			}

			result = Math.max(result, j - i + 1);
		}

		return result;
	}
}
