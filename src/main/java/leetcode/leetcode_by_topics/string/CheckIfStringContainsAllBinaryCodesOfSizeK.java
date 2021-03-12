package leetcode.leetcode_by_topics.string;

import java.util.HashSet;
import java.util.Set;

public class CheckIfStringContainsAllBinaryCodesOfSizeK {


	public boolean hasAllCodesIfThinkAgain(String s, int k) {
		Set<String> set = new HashSet<>();

		for(int i = 0; i <= s.length() - k; i++) {
			set.add(s.substring(i, i + k));
		}

		return set.size() == (int) Math.pow(2, k);
	}

	public boolean hasAllCodes(String s, int k) {
		Set<String> set = new HashSet<>();
		generate(set, k, new StringBuilder());

		for(int i = 0; i <= s.length() - k; i++) {
			String ss = s.substring(i, i + k);
			set.remove(ss);
		}

		return set.size() == 0;
	}

	public void generate(Set<String> set, int k, StringBuilder sb) {
		if(sb.length() == k) {
			set.add(sb.toString());
		} else {
			sb.append(0);
			generate(set, k, new StringBuilder(sb));
			sb.deleteCharAt(sb.length() - 1);
			sb.append(1);
			generate(set, k, new StringBuilder(sb));
		}
	}
}
