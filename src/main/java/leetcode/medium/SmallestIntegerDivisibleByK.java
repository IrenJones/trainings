package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerDivisibleByK {

	public static void main(String[] args) {
		smallestRepunitDivByK(3);
	}

	public static int smallestRepunitDivByK(int K) {
		if(K % 2 == 0 || K % 5 == 0) {
			return -1;
		}

		int remainder = 1;
		int len = 1;

		Set<Integer> set = new HashSet<>();

		// simulate long division
		while(true) {
			if(remainder % K == 0) {
				return len;
			}

			int number = remainder * 10 + 1;
			remainder = number % K;
			len++;

			if(set.contains(remainder)) {
				return -1;
			} else {
				set.add(remainder);
			}
		}
	}
}
