package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i), prev);
            if (index == -1) {
                return false;
            }
            prev = index + 1;
        }
        return true;
    }

    public boolean isSubsequenceAnother(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            List<Integer> list = map.getOrDefault(t.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(t.charAt(i), list);
        }

        int index = -1;

        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                return false;
            }

            List<Integer> list = map.get(s.charAt(i));
            int pos = findBinary(list, index, 0, list.size() -1);
            if(pos == -1){
                return false;
            }
            index = pos + 1;
        }

        return true;
    }

    private int findBinary(List<Integer> list, int index, int l, int r) {

        while(l <= r) {
            int mid = (r + l) / 2;
            if (list.get(mid) < index) {
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }

        return l == list.size() ? -1 : list.get(l);
    }
}
