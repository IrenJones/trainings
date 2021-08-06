package leetcode.leetcode_by_topics.array;

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int n = mat.length, m = mat[0].length;
        if (n * m != r * c) {
            return mat;
        }

        int i = 0, j = 0;
        int ii = 0, jj = 0;

        while (i < n && j < m) {
            res[ii][jj++] = mat[i][j++];
            if (jj == c) {
                ii++;
                jj = 0;
            }
            if (j == m) {
                i++;
                j = 0;
            }
        }

        return res;
    }
}
