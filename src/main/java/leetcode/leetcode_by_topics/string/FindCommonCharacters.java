package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        int[] chars = new int[26];
        Arrays.fill(chars, Integer.MAX_VALUE);

        for (String word : words) {
            int[] cur = new int[26];
            for (Character c : word.toCharArray()) {
                cur[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                chars[i] = Math.min(cur[i], chars[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (chars[i] > 0) {
                list.add(String.valueOf((char)(i + 'a')));
                chars[i]--;
            }
        }

        return list;
    }
}
