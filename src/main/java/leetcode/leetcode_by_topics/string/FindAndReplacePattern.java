package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public static void main(String[] args) {
        FindAndReplacePattern s = new FindAndReplacePattern();
        s.findAndReplacePattern(new String[] {"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb");
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }

        return res;
    }

    public boolean match(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> mappingReverse = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (mapping.containsKey(p.charAt(j)) && mapping.get(p.charAt(j)) != s.charAt(j) ||
                mappingReverse.containsKey(s.charAt(j)) && mappingReverse.get(s.charAt(j)) != p.charAt(j)) {
                return false;
            }
            else if (!mapping.containsKey(p.charAt(j))) {
                mapping.put(p.charAt(j), s.charAt(j));
                mappingReverse.put(s.charAt(j), p.charAt(j));
            }
        }
        return true;
    }
}
