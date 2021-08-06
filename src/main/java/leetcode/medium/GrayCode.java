package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {

    public static void main(String[] args) {
        GrayCode s  =new GrayCode();
        s.grayCode(2);
    }

    public List<Integer> grayCodeWithDef(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i ^ (i >> 1));
        }
        return list;
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        backTrack(list, set, n);
        return list;
    }

    public boolean backTrack(List<Integer> list, Set<Integer> set, int n) {
        if (list.size() == 1 << n) {
            return true;
        }

        int prev = list.get(list.size() - 1);

        for (int i = 0; i < n; i++) {
            int j = prev ^ (1 << i);
            if (!set.contains(j)) {
                list.add(j);
                set.add(j);
                if (backTrack(list, set, n)) {
                    return true;
                }
                list.remove(list.size() - 1);
                set.remove(j);
            }
        }

        return false;
    }
}
