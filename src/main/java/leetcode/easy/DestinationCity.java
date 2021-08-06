package leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> out = new HashMap<>();

        for (List<String> path : paths) {
            in.put(path.get(1), in.getOrDefault(path.get(1), 0) + 1);
            out.put(path.get(0), out.getOrDefault(path.get(0), 0) + 1);
        }

        for (Map.Entry<String, Integer> e : in.entrySet()) {
            if (!out.containsKey(e.getKey())) {
                return e.getKey();
            }
        }

        return "";
    }
}
