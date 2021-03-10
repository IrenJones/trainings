package leetcode.leetcode_by_topics.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortEncodingOfWords {

	public static void main(String[] args) {
		ShortEncodingOfWords solution = new ShortEncodingOfWords();
		solution.minimumLengthEncoding(new String[]{"time", "me", "bell"});

	}

	public int minimumLengthEncoding(String[] words) {

		Set<String> set = new HashSet<>(Arrays.asList(words));


		for (String word : words) {
			for (int start = 1; start < word.length(); start++) {
				set.remove(word.substring(start));
			}
		}

		int result = 0;
		for (String word : set) {
			result += word.length() + 1;
		}

		return result;
	}
}
