package leetcode.leetcode_by_topics.string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < Math.min(prefix.length(), strs[i].length())) {
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    if (j == 0) {
                        return "";
                    }
                    prefix = prefix.substring(0, j);
                    break;
                }
                else {
                    j++;
                }
            }

            if (prefix.length() > strs[i].length()) {
                prefix = strs[i];
            }
        }

        return prefix;
    }
}
