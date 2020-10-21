package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "cat d d fish") == false);
		System.out.println(wordPattern("abba", "cat d d cat") == true);
		System.out.println(wordPattern("aaa", "cat d d cat") == false);
	}

	public static boolean wordPattern(String pattern, String s) {
		Map<String, Character> dictionary = new HashMap<>();
		Map<Character, String> dictionarySec = new HashMap<>();

		String[] strings = s.split(" ");
		if (strings.length != pattern.length()) {
			return false;
		}

		char key;
		String sb;
		for (int i = 0; i < pattern.length(); i++) {
			sb = strings[i];
			key = pattern.charAt(i);
			if (dictionary.containsKey(sb) && dictionarySec.containsKey(key)) {
				if (!(dictionary.get(sb).equals(key) && dictionarySec.get(key).equals(sb))) {
					return false;
				}
			} else {
				if (dictionary.containsKey(sb) && !dictionarySec.containsKey(key) ||
						!dictionary.containsKey(sb) && dictionarySec.containsKey(key)) {
					return false;
				} else {
					dictionary.put(sb, key);
					dictionarySec.put(key, sb);
				}
			}
		}

		return true;
	}
}
