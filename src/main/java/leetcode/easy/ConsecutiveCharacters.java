package leetcode.easy;

public class ConsecutiveCharacters {

	public static void main(String[] args) {
		System.out.println(maxPower("ee") == 2);
		System.out.println(maxPower("leetcode") == 2);
	}

	public static int maxPower(String s) {
		if (s.length() == 1) {
			return 1;
		}
		char prev = 'a';
		int maxCount = 0;
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (i != 0 && s.charAt(i) == prev) {
				count++;
			} else {
				prev = s.charAt(i);
				maxCount = Math.max(maxCount, count);
				count = 1;
			}
		}

		return Math.max(maxCount, count);
	}
}
