package leetcode.leetcode_by_topics.bit;

public class BinaryNumberWithAlternatingBits {

	public static void main(String[] args) {
		BinaryNumberWithAlternatingBits solution = new BinaryNumberWithAlternatingBits();
		solution.hasAlternatingBits(5);
	}

	public boolean hasAlternatingBits(int n) {
		int prev = n & 1;
		n = n >> 1;
		while(n != 0) {
			if((n & 1) == prev) {
				return false;
			}
			prev = n & 1;
			n = n >> 1;
		}

		return true;
	}
}
