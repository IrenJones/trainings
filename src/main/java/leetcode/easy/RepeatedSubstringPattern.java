package leetcode.easy;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("aba") == false);
		System.out.println(repeatedSubstringPattern("abab") == true);
	}

	public static boolean repeatedSubstringPattern(String s) {
		String pattern;
		for(int i=1; i< s.length(); i++) {
			pattern = s.substring(0, i);
			for(int j=i; j < s.length() - i + 1; j+=i) {
				if(equal(s, pattern, j) && j == s.length() - i ) {
					return true;
				}
				if(!equal(s, pattern, j)) {
					break;
				}
			}
		}
		return false;
	}

	public static boolean equal(String s, String pattern, int startIndex) {

		for(int i=0; i< pattern.length(); i++) {
			if(s.charAt(i + startIndex) != pattern.charAt(i)){
				return false;
			}
		}
		return true;
	}
}
