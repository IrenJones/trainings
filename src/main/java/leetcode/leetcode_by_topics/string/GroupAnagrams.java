package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] chars = new int[26];
            for (char c : s.toCharArray()) {
                chars[c - 'a']++;
            }

            String value = Arrays.toString(chars);
            List<String> list = map.getOrDefault(value, new ArrayList<>());
            list.add(s);
            map.put(value, list);
        }

        return new ArrayList<>(map.values());
    }
}
