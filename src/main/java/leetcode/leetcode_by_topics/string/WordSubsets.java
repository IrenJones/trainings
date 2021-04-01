package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {

    public static void main(String[] args) {
        WordSubsets s = new WordSubsets();
        s.wordSubsets(new String[]{"google","leetcode"}, new String[]{"lo","eo"});
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] charsB = new int[26];

        for(String s: B) {
            int[] tmp = new int[26];
            for(char c: s.toCharArray()) {
                tmp[c - 'a']++;
            }
            for(int i = 0; i < 26; i++) {
                charsB[i] = Math.max(charsB[i], tmp[i]);
            }
        }

        Map<String, int[]> dictSetWord= new HashMap<>();
        for(String s: A) {
            int[] chars = new int[26];
            for(char c: s.toCharArray()) {
                chars[c - 'a']++;
            }
            dictSetWord.put(s, chars);
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            if(isSub(dictSetWord.get(A[i]), charsB)) {
                result.add(A[i]);
            }
        }

        return result;
    }

    private boolean isSub(int[] s, int[] ss) {

        for(int i = 0; i < 26; i++) {
            if(s[i] < ss[i]){
                return false;
            }
        }

        return true;
    }
}
