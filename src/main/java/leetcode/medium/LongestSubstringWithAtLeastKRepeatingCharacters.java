package leetcode.medium;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		longestSubstring("ababbcdd", 2);
	}

	public static int longestSubstring(String s, int k) {
		return helper(s, 0, s.length(), k);
	}

	public static int helper(String s, int start, int end, int k) {
		// too short from start to end
		if (end - start < k) {
			return 0;
		}

		int[] counts = new int[26];

		for (int i = start; i < end; i++) {
			counts[s.charAt(i) - 'a']++;
		}

		for (int mid = start; mid < end; mid++) {
			if (counts[s.charAt(mid) - 'a'] < k) {
				int midNext = mid + 1;

				while (midNext < end && counts[s.charAt(midNext) - 'a'] < k) {
					midNext++;
				}

				return Math.max(
						helper(s, start, mid, k),
						helper(s, midNext + 1, end, k)
				);
			}
		}

		return end - start;
	}
}
