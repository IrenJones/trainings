package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		List<String> result = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		System.out.println(result.get(0).equals("AAAAACCCCC"));
		System.out.println(result.get(1).equals("CCCCCAAAAA"));
	}

	// find all the 10-letter-long sequences (substrings)
	// that occur more than once in a DNA molecule
	public static List<String> findRepeatedDnaSequences(String s) {
		int windowSize = 10;

		if(s.length() <= windowSize) {
			return new ArrayList<>();
		}

		Map<String, Integer> map = new HashMap<>();
		String s1;
		for(int i=0; i< s.length() - windowSize + 1; i++) {
			s1 = s.substring(i, i + windowSize);
			map.put(s1, map.getOrDefault(s1, 0) + 1);
		}

		return map.entrySet().stream()
				.filter(e -> e.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
}
