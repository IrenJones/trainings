package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

    public static void main(String[] args) {
        NQueens s = new NQueens();
        s.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] track = new int[n][n];
        backTracking(track, res, n, n, 0, 0);
        return res;
    }

    public void backTracking(int[][] track, List<List<String>> res, int n, int q, int x, int y) {
        if (x >= n && q > 0) {
            return;
        }
        if (q == 0) {
            List<String> cur = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(track[i][j] == 2 ? 'Q' : '.');
                }
                cur.add(sb.toString());
            }
            res.add(cur);
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = y; j < n; j++) {
                if (track[i][j] == 0) {
                    int[][] copy = new int[n][n];
                    for (int k = 0; k < n; k++) {
                        copy[k] = Arrays.copyOf(track[k], n);
                    }

                    mark(copy, i, j, n);
                    copy[i][j] = 2;
                    backTracking(copy, res, n, q - 1, i + 1, 0);
                }
            }
        }
    }

    public void mark(int[][] a, int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            a[x][i] = 1;
            a[i][y] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (y - x + i >= 0 && y - x + i < n) {
                a[i][y - x + i] = 1;
            }
            if (y + x - i < n && y + x - i >= 0) {
                a[i][y + x - i] = 1;
            }
        }
    }

    public List<List<String>> solveNQueensBetter(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagLeft = new HashSet<>();
        Set<Integer> diagRight = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        backTracking(res, columns, diagLeft, diagRight, n, n, 0, new ArrayList<>());
        return res;
    }

    private void backTracking(List<List<String>> res, Set<Integer> columns, Set<Integer> left, Set<Integer> right, int q, int n, int x, List<String> list) {
        if(q == 0){
            res.add(list);
            return;
        }

        if(x >= n){
            return;
        }

        for(int i = 0; i < n ; i++){
            if(columns.contains(i) || left.contains(x - i) || right.contains(x + i)){
                continue;
            }

            char[] r = new char[n];
            Arrays.fill(r, '.');
            r[i] = 'Q';
            list.add(new String(r));
            columns.add(i);
            left.add(x - i);
            right.add(x + i);

            backTracking(res, new HashSet<>(columns), new HashSet<>(left), new HashSet<>(right), q - 1, n, x + 1, new ArrayList<>(list));

            list.remove(list.size() - 1);
            columns.remove(i);
            left.remove(x - i);
            right.remove(x + i);
        }
    }
}
