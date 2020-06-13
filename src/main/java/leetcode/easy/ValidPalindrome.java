package leetcode.easy;

import scala.util.matching.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	public static boolean isPalindrome(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		StringBuilder builder = new StringBuilder(actual);
		String s1 = builder.reverse().toString();
		return s1.equals(actual);
	}
}
