package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("IX"));
	}

	public static int romanToInt(String s) {
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'V') {
				result += 5;
			} else if (s.charAt(i) == 'X') {
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
					result -= 10;
				} else {
					result += 10;
				}
			} else if (s.charAt(i) == 'L') {
				result += 50;
			} else if (s.charAt(i) == 'C') {
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
					result -= 100;
				} else {
					result += 100;
				}
			} else if (s.charAt(i) == 'D') {
				result += 500;
			} else if (s.charAt(i) == 'M') {
				result += 1000;
			} else if (s.charAt(i) == 'I') {
				if (i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
					result -= 1;
				} else {
					result += 1;
				}
			}
		}

		return result;
	}

	public static Map<Character, Integer> initMap() {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		return map;
	}


	public static int romanToIntBetter(String s) {
		int result = 0;
		Map<Character, Integer> map = initMap();

		char prev = 'F';
		for (int i = s.length() - 1; i >= 0; i--) {
			int cur = map.get(s.charAt(i));
			if (result > cur && prev != s.charAt(i)) {
				result -= cur;
			} else {
				result += cur;
			}
			prev = s.charAt(i);
		}

		return result;
	}
}
