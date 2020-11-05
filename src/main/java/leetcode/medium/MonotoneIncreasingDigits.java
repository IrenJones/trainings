package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MonotoneIncreasingDigits {

	public static void main(String[] args) {
		//System.out.println(monotoneIncreasingDigits(324) == 299);
		//System.out.println(monotoneIncreasingDigits(1234) == 1234);
		System.out.println(monotoneIncreasingDigits(120) == 119);
	}

	public static int monotoneIncreasingDigits(int N) {
		if (N == 0) {
			return 0;
		}
		List<Integer> number = new ArrayList<>();

		int n = N;
		while (n > 0) {
			number.add(n % 10);
			n = n / 10;
		}

		if (number.size() == 1) {
			return number.get(0) - 1;
		}
		boolean isTrueNumber = true;
		for (int i = number.size() - 1; i > 0; i--) {
			if (number.get(i) > number.get(i - 1)) {
				isTrueNumber = false;
				break;
			}
		}

		if (isTrueNumber) {
			return N;
		}

		int result = 0;
		for (int i = number.size(); i > 0; i--) {
			result = defineIDigit(i, result, N);
		}

		return result;
	}

	private static int defineIDigit(int currentIndex, int currentResult, int N) {
		for (int d = 1; d <= 9; d++) {
			if (N < currentResult * Math.pow(10, currentIndex) + createNumber(d, currentIndex)) {
				return currentResult * 10 + d - 1;
			}
		}
		return currentResult * 10 + 9;
	}

	private static int createNumber(int d, int count) {
		int res = 0;
		for (int i = 0; i < count; i++) {
			res = res * 10 + d;
		}
		return res;
	}
}
