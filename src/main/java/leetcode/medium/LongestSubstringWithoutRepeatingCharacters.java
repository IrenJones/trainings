package leetcode.medium;

import org.apache.hadoop.util.hash.Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		//lengthOfLongestSubstring("abcabcbb");
		//lengthOfLongestSubstring("bbbbb");
		lengthOfLongestSubstring("pwwkew");
		//lengthOfLongestSubstring("");
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s.length() < 2) {
			return s.length();
		}

		Map<Character, Integer> cLocation = new HashMap<>();

		int startPos = 0;
		int maxLen = 0;
		for(int i=0; i< s.length(); i++) {
			if(!cLocation.containsKey(s.charAt(i))) {
				cLocation.put(s.charAt(i), i);
			} else {
				if(cLocation.get(s.charAt(i)) == startPos) {
					startPos++;
					cLocation.put(s.charAt(i), i);
					maxLen = Math.max(maxLen, cLocation.size());
				} else {
					maxLen = Math.max(maxLen, cLocation.size());
					startPos = cLocation.get(s.charAt(i)) + 1;
					// remove all prev chars
					int finalStartPos = startPos;
					cLocation.entrySet().removeIf(e -> e.getValue() < finalStartPos );
					cLocation.put(s.charAt(i), i);
				}
			}
		}

		return Math.max(maxLen, cLocation.size());
	}

	public int lengthOfLongestSubstringCoolVersion(String s) {
		Map<Character, Integer> map = new HashMap<>();

		int result = 0, startPos = 0;

		for(int i = 0; i< s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				// check if we have found the character inside current substring -
				// its position should be > startPos
				// case 1 - repeated character is not in current substring - so left startPos the same
				// case 2 - in the current substring -> move start pointer to new position
				startPos = Math.max(startPos, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			result = Math.max(result, i - startPos + 1);
		}

		return result;
	}
}
