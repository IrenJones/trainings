package leetcode.leetcode_by_topics.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {
        NumberOfSubmatricesThatSumToTarget s = new NumberOfSubmatricesThatSumToTarget();
        int[][] arr = {
            {1, -1},
            {-1, 1}
        };

        s.betterSolution(arr, 0);
    }

    // TLE
    Set<String> set = new HashSet<>();

    int count = 0;

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check(i, j, i, j, matrix, n, m, target);
            }
        }

        return count;
    }

    public void check(int x1, int y1, int x2, int y2, int[][] matrix, int n, int m, int target) {
        if (!set.contains(x1 + "_" + y1 + "_" + x2 + "_" + y2) && between(x2, 0, n) && between(y2, 0, m)) {
            set.add(x1 + "_" + y1 + "_" + x2 + "_" + y2);
            int cur = 0;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    cur += matrix[i][j];
                }
            }
            if (cur == target) {
                count++;
            }

            check(x1, y1, x2 + 1, y2, matrix, n, m, target);
            check(x1, y1, x2, y2 + 1, matrix, n, m, target);
            check(x1, y1, x2 + 1, y2 + 1, matrix, n, m, target);
        }
    }

    public boolean between(int v, int l, int h) {
        return l <= v && v < h;
    }


    // ------------------------------------

    public int betterSolution(int[][] matrix, int target){
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sum = new int[n][m];

        for(int i = 0; i < n; i++){
            sum[i][0] = matrix[i][0];
            for(int j = 1; j < m; j++){
                sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }

        for(int start = 0; start < m; start++){
            for(int end = start; end < m; end++){
                int res = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                for(int line = 0; line < n; line++){
                    int prefixSum = start > 0 ? sum[line][start - 1] : 0;
                    res += sum[line][end] - prefixSum;
                    if(map.containsKey(res - target)){
                        count += map.get(res - target);
                    }
                    map.put(res, map.getOrDefault(res, 0) + 1);
                }
            }
        }

        return count;
    }

}
