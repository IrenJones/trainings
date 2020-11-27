package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {

	public int uniqueMorseRepresentations(String[] words) {
		String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....",
				"..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
				"..-","...-",".--","-..-","-.--","--.."};

		Set<String> uniqueWords = new HashSet<>();

		for(String word: words) {
			StringBuilder sb = new StringBuilder();
			for(char c: word.toCharArray()){
				sb.append(codes[c - 'a']);
			}
			uniqueWords.add(sb.toString());
		}

		return uniqueWords.size();
	}
}
