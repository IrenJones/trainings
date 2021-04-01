package leetcode.leetcode_by_topics.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StampingTheSequence {

    public static void main(String[] args) {
        StampingTheSequence s = new StampingTheSequence();
        s.movesToStamp("abc", "ababc");
    }

    public int[] movesToStamp(String stamp, String target) {

        if (target.length() == stamp.length()) {
            return stamp.equals(target)
                ? new int[] {0}
                : new int[0];
        }

        int sLen = stamp.length();
        int tLen = target.length();

        Set<Character> sSet = new HashSet<>();
        for (int i = 0; i < sLen; i++) {
            sSet.add(stamp.charAt(i));
        }

        Set<Character> tSet = new HashSet<>();
        for (int i = 0; i < tLen; i++) {
            tSet.add(target.charAt(i));
        }
        // target contains chars that we don't have in stamp
        // so, obviously, we cannot reach the goal
        tSet.removeAll(sSet);
        if (tSet.size() > 0) {
            return new int[0];
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        boolean wasVisited = false;
        boolean[] visited = new boolean[tLen];

        char[] arr = new char[tLen];
        int ind = 0;
        for (char c : target.toCharArray()) {
            arr[ind++] = c;
        }

        while (count != tLen) {
            wasVisited = false;
            for (int i = 0; i < tLen; i++) {
                if (!visited[i]) {
                    if (canCover(arr, stamp, i)) {
                        wasVisited = true;
                        for (int j = 0; j < sLen; j++) {
                            if (arr[i + j] != '?') {
                                arr[i + j] = '?';
                                count++;
                            }
                        }
                        list.add(i);
                        visited[i] = true;
                        break;
                    }
                }
            }

            if (!wasVisited) {
                return new int[0];
            }
        }

        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(list.size() - 1 - i);
        }

        return res;
    }

    public boolean canCover(char[] arr, String stamp, int index) {
        int j = 0;

        while (j < stamp.length() && index + j < arr.length) {
            if (stamp.charAt(j) != arr[index + j] && arr[index + j] != '?') {
                return false;
            }
            j++;
        }

        return j == stamp.length();
    }
}
