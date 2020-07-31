package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	public static void main(String[] args) {
		System.out.println(!canConstruct("a", "b"));
		System.out.println(!canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> mapMagazine = new HashMap();

		for (int i = 0; i < magazine.length(); i++) {
			char character = magazine.charAt(i);
			mapMagazine.put(character, mapMagazine.getOrDefault(character, 0) + 1);
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			char character = ransomNote.charAt(i);
			if(mapMagazine.containsKey(character)){
				Integer count = mapMagazine.get(character);
				if(count == 1){
					mapMagazine.remove(character);
				} else{
					mapMagazine.put(character, count-1);
				}
			} else{
				return false;
			}
		}
		return true;
	}
}
