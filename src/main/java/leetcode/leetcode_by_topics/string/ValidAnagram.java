package leetcode.leetcode_by_topics.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("a", "n"));
	}
	public static boolean isAnagram(String s, String t) {
		Map<Character, Integer> mapS = new HashMap();
		for(char c: s.toLowerCase().toCharArray()){
			mapS.put(Character.valueOf(c), mapS.getOrDefault(Character.valueOf(c), 0) + 1);
		}

		for(char c: t.toLowerCase().toCharArray()){
			Character character = Character.valueOf(c);
			if(mapS.containsKey(character)){
				if(mapS.get(character) == 1){
					mapS.remove(character);
				} else{
					mapS.put(character, mapS.get(character) - 1);
				}
			} else{
				return false;
			}
		}
		return mapS.size() == 0;
	}
}
