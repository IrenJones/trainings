package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		partition("aab");
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<>();
		backTracking(list, s, 0, new ArrayList<>());
		return list;
	}

	private static void backTracking(List<List<String>> list, String s, int start, List<String> current) {
		if(start >= s.length()) {
			list.add(current);
			return;
		}

		for(int size = 1; size <= s.length() - start; size++) {
			if(isPalindrome(s.subSequence(start, start + size))) {
				current.add(s.subSequence(start, start + size).toString());
				backTracking(list, s, start + size, new ArrayList<>(current));
				current.remove(current.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(CharSequence cs){
		if(cs.length() == 1) {
			return true;
		}

		for(int i = 0; i <= cs.length()/2; i++) {
			if(cs.charAt(i) != cs.charAt(cs.length() - i - 1)){
				return false;
			}
		}
		return true;
	}
}
