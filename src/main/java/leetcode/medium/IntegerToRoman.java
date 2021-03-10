package leetcode.medium;

public class IntegerToRoman {

	public static void main(String[] args) {
		IntegerToRoman solution = new IntegerToRoman();
		solution.intToRoman(9);
	}


	public String intToRoman(int num) {

		int[] divisors = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < divisors.length; i++) {
			int divisor = divisors[i];
			while (num / divisor != 0) {
				sb.append(values[i]);
				num -= divisor;
			}
		}

		return sb.toString();
	}

	public static String intToRomanIfYouReadAgain(int num) {
		String M[] = {"", "M", "MM", "MMM"};
		String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}
}
