package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int cell = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        int round = 0;

        while (cell <= n * m) {
            for (int i = round; i < m - round && cell <= n * m; i++) {
                list.add(matrix[round][i]);
                cell++;
            }

            for (int i = round + 1; i < n - round && cell <= n * m; i++) {
                list.add(matrix[i][m - round - 1]);
                cell++;
            }

            for (int i = m - round - 2; i >= round && cell <= n * m; i--) {
                list.add(matrix[n - round - 1][i]);
                cell++;
            }

            for (int i = n - round - 2; i >= round + 1 && cell <= n * m; i--) {
                list.add(matrix[i][round]);
                cell++;
            }
            round++;
        }

        return list;
    }
}
