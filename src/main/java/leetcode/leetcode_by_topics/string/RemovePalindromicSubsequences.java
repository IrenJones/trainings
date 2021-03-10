package leetcode.leetcode_by_topics.string;

public class RemovePalindromicSubsequences {
	public int removePalindromeSub(String s) {

		if(s.length() == 0) {
			return 0;
		}

		// there are only two cases
		// 1. the input string is palindrome
		if(s.equals(new StringBuilder(s).reverse().toString())) {
			return 1;
		}

		// and default answer :)
		// substring allows us to remove any amount of letters from input string
		// that means that we can combine all 'a' and 'b' into two different strings = 2 operations
		// if we would have more than two possible letters - in that case we need to find out
		// the size of set of letters
		return 2;
	}
}
