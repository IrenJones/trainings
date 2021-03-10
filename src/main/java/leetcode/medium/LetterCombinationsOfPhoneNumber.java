package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

	public List<String> letterCombinations(String digits) {
		if(digits.length() == 0) {
			return new ArrayList<>();
		}

		Map<Integer, char[]> map = new HashMap<>();
		map.put(2, new char[]{'a', 'b', 'c'});
		map.put(3, new char[]{'d', 'e', 'f'});
		map.put(4, new char[]{'g', 'h', 'i'});
		map.put(5, new char[]{'j', 'k', 'l'});
		map.put(6, new char[]{'m', 'n', 'o'});
		map.put(7, new char[]{'p', 'q', 'r', 's'});
		map.put(8, new char[]{'t', 'u', 'v'});
		map.put(9, new char[]{'w', 'x', 'y', 'z'});

		List<String> results = new ArrayList<>();
		backTrack(map, digits, 0, new StringBuilder(), results);
		return results;
	}

	public void backTrack(Map<Integer, char[]> map, String digits, int index, StringBuilder current, List<String> res) {
		if(index == digits.length()) {
			res.add(current.toString());
			return;
		}

		for(char c: map.get(digits.charAt(index) - '0')) {
			current.append(c);
			backTrack(map, digits, index + 1, new StringBuilder(current), res);
			current.deleteCharAt(current.length() - 1);
		}

	}
}
