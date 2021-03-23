package leetcode.leetcode_by_topics.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms s = new KeysAndRooms();
        s.canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), new ArrayList<>()));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 1) {
            return true;
        }

        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        dfs(rooms, 0, visited);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        for (int r : rooms.get(room)) {
            if (!visited[r]) {
                visited[r] = true;
                dfs(rooms, r, visited);
            }
        }
    }
}
