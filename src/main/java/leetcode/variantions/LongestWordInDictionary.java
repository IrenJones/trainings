package leetcode.variantions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWordInDictionary {
	public static void main(String[] args) {
		System.out.println(longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
		System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
		System.out.println(longestWord(new String[]{"a", "b", "c"}));
	}

	public static String longestWord(String[] words) {
		int[] weight = new int[words.length];
		List<Dic> list = new ArrayList<>();

		boolean isEmpty = true;

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (j != i && words[i].toLowerCase().startsWith(words[j].toLowerCase())) {
					weight[i]++;
				}
			}
			if (weight[i] != 0) {
				isEmpty = false;
			}
			list.add(new Dic(weight[i], words[i]));
		}
		if (isEmpty) {
			return "";
		}
		Collections.sort(list,
				Comparator.comparing(Dic::getWeight)
						.reversed()
						.thenComparing(Dic::getWord)
		);
		return list.get(0).word;
	}

	static class Dic {

		private int weight;
		private String word;

		public Dic() {
		}

		public Dic(int weight, String word) {
			this.weight = weight;
			this.word = word;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

	}
}
