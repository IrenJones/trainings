package leetcode.leetcode_by_topics.array;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxPath = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] results = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPath = Math.max(maxPath, calculate(matrix, i, j, n, m, results));
            }
        }

        return maxPath;
    }

    public int calculate(int[][] a, int x, int y, int n, int m, int[][] count) {
        if(count[x][y] != 0) {
            return count[x][y];
        }
        if (x >= 0 && x < n && y >= 0 && y < m) {
            int res = 1;
            if (x - 1 >= 0 && a[x][y] < a[x - 1][y]) {
                res = Math.max(res, 1 + calculate(a, x - 1, y, n, m, count));
            }
            if (x + 1 < n && a[x][y] < a[x + 1][y]) {
                res = Math.max(res, 1 + calculate(a, x + 1, y, n, m, count));
            }
            if (y - 1 >= 0 && a[x][y] < a[x][y - 1]) {
                res = Math.max(res, 1 + calculate(a, x, y - 1, n, m, count));
            }
            if (y + 1 < m && a[x][y] < a[x][y + 1]) {
                res = Math.max(res, 1 + calculate(a, x, y + 1, n, m, count));
            }
            count[x][y] = res;
            return res;
        }
        return 0;
    }
}
