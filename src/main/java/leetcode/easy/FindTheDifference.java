package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

	public static void main(String[] args) {
		findTheDifferenceBit("kaef", "kafef");
	}

	public static char findTheDifferenceBit(String s, String t) {
		char result = t.charAt(t.length() - 1);

		for(int i=0; i < s.length(); i++) {
			result^= s.charAt(i) ^ t.charAt(i);
		}
		return result;
	}

	public char findTheDifference(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		for(int i=0; i< t.length(); i++) {
			if(!map.containsKey(t.charAt(i))) {
				return t.charAt(i);
			} else {
				map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
			}
		}

		for(Map.Entry<Character, Integer> e: map.entrySet()) {
			if(e.getValue() == -1) {
				return e.getKey();
			}
		}
		return ' ';
	}
}
