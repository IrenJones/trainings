package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {

	public static void main(String[] args) {
		VerifyingAlienDictionary solution = new VerifyingAlienDictionary();
		solution.isAlienSortedAdjCheck(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
	}

	Map<Character, Integer> dict;

	public boolean isAlienSorted(String[] words, String order) {
		dict = new HashMap<>();

		for(int i = 0; i < order.length(); i++) {
			dict.put(order.charAt(i), i + 1);
		}

		String[] sorted = Arrays.copyOf(words, words.length);
		Comparator<String> comparator = this::compareWord;
		Arrays.sort(sorted, comparator);

		for(int i = 0; i < words.length; i++) {
			if(!words[i].equals(sorted[i])) {
				return false;
			}
		}

		return true;
	}

	private int compareWord(String a, String b) {
		int smallSize = Math.min(a.length(), b.length());

		for(int i = 0; i < smallSize; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				return dict.get(a.charAt(i)) > dict.get(b.charAt(i))
						? 1
						: -1;
			}
		}
		return Integer.compare(a.length(), b.length());
	}


	/* ---------- */

	public boolean isAlienSortedAdjCheck(String[] words, String order) {
		dict = new HashMap<>();

		for(int i = 0; i < order.length(); i++) {
			dict.put(order.charAt(i), i + 1);
		}

		checkNext: for(int i = 0; i < words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];

			for(int index = 0; index < Math.min(w1.length(), w2.length()); index++) {
				if(w1.charAt(index) != w2.charAt(index)){
					if(dict.get(w1.charAt(index)) > dict.get(w2.charAt(index))) {
						return false;
					} else {
						continue checkNext;
					}
				}
			}

			if(w1.length() > w2.length()) {
				return false;
			}
		}

		return true;
	}
}
