package leetcode.leetcode_by_topics.bit;

public class NumberOf1Bits {

	public int hammingWeight(int n) {
		int result = 0;

		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				result++;
			}
			n = n >> 1;
		}

		return result;
	}
}
