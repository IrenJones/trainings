package leetcode.leetcode_by_topics.array;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> mapSec = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
                else if (mapSec.containsKey(b)) {
                    if (mapSec.get(b) != a) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                if (mapSec.containsKey(b)) {
                    return false;
                }
                map.put(a, b);
                mapSec.put(b, a);
            }
        }
        return true;
    }
}
