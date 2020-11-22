package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NumbersAtMostNGivenDigitSet {

	public static void main(String[] args) {
		System.out.println(atMostNGivenDigitSet(new String[]{"3", "4", "5", "6"}, 64) == 18);
		System.out.println(atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100) == 20);
		System.out.println(atMostNGivenDigitSet(new String[]{"7"}, 8) == 1);
		System.out.println(atMostNGivenDigitSet(new String[]{"1", "4", "9"}, 1000000000) == 29523);
	}

	public static int atMostNGivenDigitSet(String[] digits, int n) {
		// convert array
		int[] digitsInt = new int[digits.length];
		for(int i=0; i< digits.length; i++) {
			digitsInt[i] = Integer.parseInt(digits[i]);
		}

		// 1 step - define count of numbers in n
		List<Integer> nList = new ArrayList<>();
		int current = n;
		while(current > 0) {
			nList.add(current % 10);
			current = current/10;
		}
		int rankN = nList.size();

		int result = 0;
		int currentRank = 1;
		while(currentRank < rankN) {
			result += Math.pow(digits.length, currentRank);
			currentRank++;
		}

		int[] dp = new int[rankN + 1];
		dp[rankN] = 1;
		for (int i=0; i < rankN; i++) {
			for(int j=0; j< digitsInt.length; j++) {
				if(digitsInt[j] < nList.get(i)){
					// calculate possible values for previous rank if
					// that digit is less (that means that all numbers will be ok,
					// F.e. if n = 64, current digit is 6 and nList(i) = 4 that means that for second digit we can choose
					// any digit from set (43, 44, 45, 46)).

					// in case n = 564 and current digit is 3 we can get
					// (1 * 4 * 4) - count of possible variants
					dp[rankN - 1 - i] += Math.pow(digitsInt.length, i);
				} else if(digitsInt[j] == nList.get(i)){
					dp[rankN - 1 - i] += dp[rankN - i];
				}
			}
		}

		return result + dp[0];
	}
}
