package leetcode.leetcode_by_topics.bit;

public class BitwiseANDOfNumbersRange {

	public int rangeBitwiseAnd(int left, int right) {
		if (left == 0) {
			return 0;
		}

		int shift = 1;

		while (left != right) {
			left = left >> 1;
			right = right >> 1;
			shift = shift << 1;
		}

		return left * shift;
	}

	public int rangeBitwiseAndTheSame(int left, int right) {
		if(left == 0) {
			return 0;
		}

		int shift = 0;

		while(left != right) {
			left = left >> 1;
			right = right >> 1;
			shift++;
		}

		return left << shift;
	}
}
