package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {

	public static void main(String[] args) {
		findAnagrams("cbaebabacd", "abc");
	}

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();

		if (s == null || s.length() == 0) {
			return result;
		}

		int[] chars = new int[26];

		for (int i = 0; i < p.length(); i++) {
			chars[p.charAt(i) - 'a']++;
		}

		int left = 0;
		int right = 0;
		int count = p.length();
		char c;

		while (right < s.length()) {
			c = s.charAt(right);
			if (chars[c - 'a'] >= 1) {
				count--;
			}
			right++;
			chars[c - 'a']--;

			if (count == 0) {
				result.add(left);
			}

			c = s.charAt(left);
			if (right - left == p.length()) {
				if (chars[c - 'a'] >= 0) {
					count++;
				}
				left++;
				chars[c - 'a']++;
			}
		}
			return result;
		}
	}
