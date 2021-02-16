package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		LetterCasePermutation solution = new LetterCasePermutation();
		solution.letterCasePermutation("a1b2").forEach(System.out::println);
	}

	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		backTracking(S, 0, result, new StringBuilder());
		return result;
	}

	public void backTracking(String s, int i, List<String> res, StringBuilder sb) {
		if(i >= s.length()) {
			res.add(sb.toString());
			return;
		}

		if(Character.isDigit(s.charAt(i))) {
			sb.append(s.charAt(i));
			backTracking(s, i+ 1, res, sb);
		} else {
			sb.append(Character.toLowerCase(s.charAt(i)));
			backTracking(s, i + 1, res, new StringBuilder(sb));
			sb.deleteCharAt(sb.length() - 1);
			sb.append(Character.toUpperCase(s.charAt(i)));
			backTracking(s, i + 1, res, new StringBuilder(sb));
		}
	}
}
