package leetcode.easy;

public class ReverseBits {

	public static void main(String[] args) {
		reverseBits(43261596);
	}

	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		int result = 0;
		for(int i=0; i < 32; i++) {
			result = result << 1;
			result = result + (n & 1);
			n = n >> 1;
		}
		return result;
	}

}
