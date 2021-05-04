package leetcode.leetcode_by_topics.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> list : wall) {
            int x = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                }
                x += list.get(i);
            }
        }

        int minRes = wall.size();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            minRes = Math.min(minRes, n - e.getValue());
            if (minRes == 0) {
                return minRes;
            }
        }

        return minRes;
    }
}
