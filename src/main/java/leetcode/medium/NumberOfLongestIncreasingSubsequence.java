package leetcode.medium;

public class NumberOfLongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}) == 2);
	}

	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		if(n < 2) {
			return n;
		}

		int[] lens = new int[n];
		int[] count = new int[n];

		int maxLength = 0;
		int countMaxLength = 0;

		for(int i=0; i< n; i++) {

			lens[i] = 1;
			count[i] = 1;

			for(int j=0; j < i; j++) {
				// end is greater than element before
				if(nums[i] > nums[j]) {
					// if we have already have the sequence with such size before i element
					if (lens[j] + 1 == lens[i]) {
						count[i] = count[i] + count[j];
					} else if(lens[j] + 1 > lens[i]) {
						// new sequence is bigger than existing, update all values for i element
						lens[i] = lens[j] + 1;
						count[i] = count[j];
					}
				}
			}

			if(maxLength < lens[i]) {
				// update max length
				maxLength = lens[i];
				countMaxLength = count[i];
			} else if(maxLength == lens[i]) {
				// update count of sequences with max length
				countMaxLength = countMaxLength + count[i];
			}
		}
		return countMaxLength;
	}
}
