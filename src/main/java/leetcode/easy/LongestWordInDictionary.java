package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestWordInDictionary {
	public static void main(String[] args) {
		System.out.println(longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
		System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
		System.out.println(longestWord(new String[]{"a", "b", "c"}));
	}

	public static String longestWord(String[] words) {
		String result = "";
		Set<String> set = new HashSet<>();
		Collections.addAll(set, words);

		for (String word: words) {
			if (word.length() > result.length() ||
					word.length() == result.length()
							&& word.compareTo(result) < 0) {
				boolean goodWord = true;
				for (int k = 1; k < word.length(); k++) {
					if (!set.contains(word.substring(0, k))) {
						goodWord = false;
						break;
					}
				}
				if (goodWord){
					result = word;
				}
			}
		}
		return result;
	}
}
