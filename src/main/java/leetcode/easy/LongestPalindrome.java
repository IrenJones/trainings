package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd") == 7);
		System.out.println(longestPalindrome("dd") == 2);
		System.out.println(longestPalindrome("a") == 1);
	}

	public static int longestPalindrome(String s) {
		int result = 0;
		if(s.length() < 1){
			return 0;
		} else if (s.length() == 1){
			return 1;
		} else{
			Map<Character, Integer> map = new HashMap(){};
			for(char c: s.toCharArray()){
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			for(Map.Entry<Character, Integer> entry: map.entrySet()){
				result+= entry.getValue()/2*2;
			}

			return result < s.length()? result + 1: result;
		}
	}
}
