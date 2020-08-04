package leetcode.easy;

import scala.util.matching.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindromeTwoPointers("A man, a plan, a canal: Panama"));
	}

	public static boolean isPalindrome(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		StringBuilder builder = new StringBuilder(actual);
		String s1 = builder.reverse().toString();
		return s1.equals(actual);
	}

	public static boolean isPalindromeTwoPointers(String s) {
		if (s.isEmpty()) {
			return true;
		}

		int pointerHead = 0;
		int pointerLast = s.length() - 1;

		while (pointerHead < pointerLast) {
			if (!Character.isLetterOrDigit(s.charAt(pointerHead))) {
				pointerHead++;
			} else if (!Character.isLetterOrDigit(s.charAt(pointerLast))) {
				pointerLast--;
			} else if (Character.toLowerCase(s.charAt(pointerHead)) != Character.toLowerCase(s.charAt(pointerLast))) {
				return false;
			} else {
				pointerHead++;
				pointerLast--;
			}
		}
		return true;
	}
}
