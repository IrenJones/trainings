package leetcode.leetcode_by_topics.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {

    public static void main(String[] args) {
        VowelSpellchecker s = new VowelSpellchecker();
        s.spellchecker(new String[] {"KiTe", "kite", "hare", "Hare"},
            new String[] {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"});
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> dict = new HashSet<>();
        Map<String, String> mapLc = new HashMap<>();
        Map<String, String> mapVw = new HashMap<>();
        for (String word : wordlist) {
            dict.add(word);
            mapLc.putIfAbsent(word.toLowerCase(), word);
            mapVw.putIfAbsent(word.toLowerCase().replaceAll("[aeoiu]", "1"), word);
        }

        String[] res = new String[queries.length];
        int i = 0;
        for (String w : queries) {
            if (dict.contains(w)) {
                res[i++] = w;
            }
            else {
                String r = capitalization(mapLc, w);
                if (r != null) {
                    res[i++] = r;
                }
                else {
                    r = vowelChecking(mapVw, w);
                    if (r != null) {
                        res[i++] = r;
                    }
                    else {
                        res[i++] = "";
                    }
                }
            }
        }

        return res;
    }

    public String capitalization(Map<String, String> mapLc, String w) {
        if (mapLc.containsKey(w.toLowerCase())) {
            return mapLc.get(w.toLowerCase());
        }
        return null;
    }

    public String vowelChecking(Map<String, String> mapVw, String w) {
        String r = w.toLowerCase().replaceAll("[aeoiu]", "1");
        if (mapVw.containsKey(r)) {
            return mapVw.get(r);
        }

        return null;
    }
}
