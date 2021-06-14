package leetcode.leetcode_by_topics.string;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        Map<String, int[]> map = new HashMap<>();

        for (String word : words) {
            map.put(word, getArray(word));
        }

        int res = 0;
        for (Map.Entry<String, int[]> e : map.entrySet()) {
            for (Map.Entry<String, int[]> e2 : map.entrySet()) {
                if (!e.getKey().equals(e2.getKey())) {
                    boolean hasSame = false;
                    for (int i = 0; i < 26; i++) {
                        if (e.getValue()[i] != 0 && e2.getValue()[i] != 0) {
                            hasSame = true;
                            break;
                        }
                    }
                    if (!hasSame) {
                        res = Math.max(res, e.getKey().length() * e2.getKey().length());
                    }
                }
            }
        }

        return res;
    }

    public int[] getArray(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        return a;
    }

    public int maxProductBetter(String[] words) {
        int n = words.length;
        int[] bytes = new int[n];

        for (int i = 0; i < n; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                bytes[i] = bytes[i] | (1 << (s.charAt(j) - 'a'));
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }
}
