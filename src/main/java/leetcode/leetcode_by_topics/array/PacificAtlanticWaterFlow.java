package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        PacificAtlanticWaterFlow s = new PacificAtlanticWaterFlow();
        int[][] m = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        s.pacificAtlantic(m);
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] checkedAtl = new boolean[n][m];
        boolean[][] checkedPac = new boolean[n][m];

        Queue<List<Integer>> atl = new LinkedList<>();
        Queue<List<Integer>> pac = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    pac.add(Arrays.asList(i, j));
                }
                if (i == n - 1 || j == m - 1) {
                    atl.add(Arrays.asList(i, j));
                }
            }
        }

        checkOcean(n, m, checkedAtl, atl, matrix);
        checkOcean(n, m, checkedPac, pac, matrix);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (checkedAtl[i][j] && checkedPac[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void checkOcean(int n, int m, boolean[][] checked, Queue<List<Integer>> q, int[][] matrix) {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<Integer> point = q.poll();
                int x = point.get(0);
                int y = point.get(1);
                if (!checked[x][y]) {
                    checked[x][y] = true;
                    if (x - 1 >= 0 && matrix[x][y] <= matrix[x - 1][y]) {
                        q.add(Arrays.asList(x - 1, y));
                    }
                    if (y - 1 >= 0 && matrix[x][y] <= matrix[x][y - 1]) {
                        q.add(Arrays.asList(x, y - 1));
                    }
                    if (x + 1 < n && matrix[x][y] <= matrix[x + 1][y]) {
                        q.add(Arrays.asList(x + 1, y));
                    }
                    if (y + 1 < m && matrix[x][y] <= matrix[x][y + 1]) {
                        q.add(Arrays.asList(x, y + 1));
                    }
                }
            }
        }
    }
}
