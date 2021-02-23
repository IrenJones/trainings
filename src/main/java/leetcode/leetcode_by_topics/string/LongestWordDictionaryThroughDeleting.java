package leetcode.leetcode_by_topics.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LongestWordDictionaryThroughDeleting {

	public static void main(String[] args) {
		LongestWordDictionaryThroughDeleting solution = new LongestWordDictionaryThroughDeleting();
		System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
	}

	public String findLongestWord(String s, List<String> d) {
		String defaultResult = "";
		PriorityQueue<String> possibleResults = new PriorityQueue<>(
				Comparator.comparingInt(String::length)
						.reversed()
						.thenComparing(String::compareTo));

		for(String word: d) {
			if(canBeCreated(word, s)) {
				possibleResults.add(word);
			}
		}

		return possibleResults.size() > 0
				? possibleResults.peek()
				: defaultResult;
	}

	private boolean canBeCreated(String word, String inputS) {
		if(word.length() > inputS.length()) {
			return false;
		}

		if(word.equals(inputS)) {
			return true;
		}

		int wordIndex = 0;
		int index = 0;
		while(true) {
			if(wordIndex >= word.length()) {
				return true;
			}
			if(index >= inputS.length()) {
				return false;
			}
			if(word.charAt(wordIndex) == inputS.charAt(index)) {
				wordIndex++;
			}

			index++;
		}
	}
}
