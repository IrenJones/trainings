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

        s.numSubmatrixSumTarget(arr, 0);
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

        int n = matrix.length;
        int m = matrix[0].length;

        int res = 0;
        int[][] sum = new int[n][m + 1];

        for (int i = 0; i < sum.length; i++){
            for (int j = 1; j < sum[0].length; j++){
                sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
            }
        }


        for (int start = 0; start < m + 1; start++){
            for (int end = start + 1; end < m + 1; end++ ){
                int curSum = 0;
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, 1);
                for(int l = 0; l < n; l++){
                    curSum += sum[l][end] - sum[l][start];
                    if (map.containsKey(curSum - target))
                        res += map.get(curSum - target);
                    map.put(curSum, map.getOrDefault(curSum, 0) + 1);

                }
            }
        }

        return res;
    }

}
