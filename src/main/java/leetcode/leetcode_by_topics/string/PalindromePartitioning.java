package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args) {
		PalindromePartitioning solution = new PalindromePartitioning();
		solution.partition("aab");
	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		backTracking(s, 0, new ArrayList<>(), result);
		return result;
	}

	public void backTracking(String s, int pos, List<String> currentList, List<List<String>> res){

		if(pos >= s.length()){
			res.add(currentList);
			return;
		}

		for(int size = 1; size <= s.length() - pos; size++) {
			if(isPalindrome(s, pos, size)) {
				currentList.add(s.substring(pos, pos + size));
				backTracking(s, pos + size, new ArrayList(currentList), res);
				currentList.remove(currentList.size() - 1);
			}
		}

	}

	public boolean isPalindrome(String s, int start, int sizeOfWord){
		if(sizeOfWord == 1) {
			return true;
		}

		int endIndex = start + sizeOfWord;
		for (int i = 0; i < sizeOfWord / 2; i++) {
			if(s.charAt(start + i) != s.charAt(endIndex - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
