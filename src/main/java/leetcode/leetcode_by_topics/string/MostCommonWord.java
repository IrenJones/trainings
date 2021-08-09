package leetcode.leetcode_by_topics.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>();
        for(String word: banned){
            set.add(word);
        }

        String res = null;
        int freq = 0;
        String s = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        for(String word: s.split("\\s+")){
            if(set.contains(word)){
                continue;
            }
            int curFreq = map.getOrDefault(word, 0) + 1;
            if(curFreq > freq){
                res = word;
                freq = curFreq;
            }
            map.put(word, curFreq);
        }

        return res;
    }

    public String mostCommonWordBetter(String paragraph, String[] banned) {
        Set<String> dictBan = new HashSet<>();
        for(String word: banned){
            dictBan.add(word);
        }

        String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").split("\\s+");
        Map<String, Integer> map = new HashMap<>();

        for(String word: words){
            word = word.toLowerCase();
            if(!dictBan.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
