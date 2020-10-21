package leetcode.medium;

public class PalindromicSubstrings {
	public static void main(String[] args) {
		//System.out.println(countSubstrings("abc") == 3);
		System.out.println(countSubstrings("aaa") == 6);
		System.out.println(countSubstrings("abc") == 3);
	}

	public static int countSubstrings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if(s.length() == 1) {
			return 1;
		}

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += countPalindromes(s, i, i); // with central symbol
			count += countPalindromes(s, i, i + 1); // without central symbol
		}
		return count;
	}

	private static int countPalindromes(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
			count++;
		}
		return count;
	}
}
