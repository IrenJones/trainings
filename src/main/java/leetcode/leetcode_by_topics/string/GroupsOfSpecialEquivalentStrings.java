package leetcode.leetcode_by_topics.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupsOfSpecialEquivalentStrings {

    public static void main(String[] args) {
        GroupsOfSpecialEquivalentStrings s = new GroupsOfSpecialEquivalentStrings();
        s.numSpecialEquivGroups(new String[] {"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx", "abcd"});
    }

    public int numSpecialEquivGroups(String[] words) {
        Set<String> combinations = new HashSet<>();

        for (String word : words) {
            int[] even = new int[26];
            int[] odd = new int[26];
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    even[word.charAt(i) - 'a']++;
                }
                else {
                    odd[word.charAt(i) - 'a']++;
                }
            }
            combinations.add(Arrays.toString(even) + " " + Arrays.toString(odd));
        }

        return combinations.size();
    }

    public int numSpecialEquivGroupsFirstTry(String[] words) {
        Map<String, Map<Integer, int[]>> dict = new HashMap<>();
        Set<String> deleted = new HashSet<>();

        for (String word : words) {
            if (!dict.containsKey(word)) {
                Map<Integer, int[]> map = new HashMap<>();
                int[] even = new int[26];
                int[] odd = new int[26];
                for (int i = 0; i < word.length(); i++) {
                    if (i % 2 == 0) {
                        even[word.charAt(i) - 'a']++;
                    }
                    else {
                        odd[word.charAt(i) - 'a']++;
                    }
                }
                map.put(0, even);
                map.put(1, odd);

                dict.put(word, map);
            }
        }

        for (Map.Entry<String, Map<Integer, int[]>> e : dict.entrySet()) {
            for (Map.Entry<String, Map<Integer, int[]>> e2 : dict.entrySet()) {
                if (!deleted.contains(e.getKey()) && !deleted.contains(e2.getKey()) && !e.getKey().equals(e2.getKey())) {
                    Map<Integer, int[]> firstStringChars = e.getValue();
                    Map<Integer, int[]> secondStringChars = e2.getValue();
                    if (Arrays.equals(firstStringChars.get(0), secondStringChars.get(0))
                        && Arrays.equals(firstStringChars.get(1), secondStringChars.get(1))) {
                        deleted.add(e2.getKey());
                    }
                }
            }
        }

        return dict.size() - deleted.size();
    }
}
