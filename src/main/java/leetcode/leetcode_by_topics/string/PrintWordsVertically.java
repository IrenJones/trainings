package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrintWordsVertically {

    public List<String> printVertically(String s) {
        String[] words = s.trim().split(" ");
        List<StringBuilder> list = new ArrayList<>();

        int maxLen = 0;
        for (String w : words) {
            maxLen = Math.max(w.length(), maxLen);
        }

        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String w : words) {
                sb.append(w.length() - 1 < i ? ' ' : w.charAt(i));
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            list.add(sb);
        }

        return list.stream()
            .map(sb -> sb.toString())
            .collect(Collectors.toList());
    }
}
