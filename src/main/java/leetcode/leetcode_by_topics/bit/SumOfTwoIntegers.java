package leetcode.leetcode_by_topics.bit;

public class SumOfTwoIntegers {

	public int getSum(int a, int b) {
		// Sum of two bits can be obtained by performing XOR (^) of the two bits.
		// Carry bit can be obtained by performing AND (&) of two bits.
		// Iterate till there is no carry
		while (b != 0) {
			// carry now contains common
			// set bits of a and b
			int carry = a & b;

			// Sum of bits of a and b where at least one
			// of the bits is not set
			a = a ^ b;

			// Carry is shifted by one so that adding it
			// to a gives the required sum
			b = carry << 1;
		}
		return a;
	}
}
