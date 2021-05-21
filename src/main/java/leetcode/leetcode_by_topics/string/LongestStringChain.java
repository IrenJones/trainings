package leetcode.leetcode_by_topics.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public static void main(String[] args) {
        LongestStringChain s = new LongestStringChain();
        s.longestStrChain(new String[]{"a","ab","ac","bd","abc","abd","abdd"});
    }

    public int longestStrChain(String[] words) {
        int res = 1;
        Comparator<String> comparator = Comparator.comparing(String::length);
        Arrays.sort(words, comparator);

        int minLen = words[0].length();

        Map<String, Integer> map = new HashMap<>();

        for(String word: words){
            res = Math.max(checkChain(word, map, minLen), res);
        }

        return res;
    }

    private int checkChain(String word, Map<String, Integer> map, int minLen) {
        int maxValue = 1;

        if(word.length() != minLen){
            for(int i = 0; i < word.length(); i++){
                String res = combine(word, i);
                if(map.containsKey(res)){
                    maxValue = Math.max(maxValue, map.get(res) + 1);
                }
            }

        }

        map.put(word, maxValue);
        return maxValue;
    }

    private String combine(String word, int i) {
        StringBuilder build = new StringBuilder(word);
        build.deleteCharAt(i);
        return build.toString();
    }
}
