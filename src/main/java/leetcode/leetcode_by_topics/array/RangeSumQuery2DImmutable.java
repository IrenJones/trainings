package leetcode.leetcode_by_topics.array;

public class RangeSumQuery2DImmutable {

    public static void main(String[] args) {
        int[][] arr = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5},
        };
        NumMatrix s = new NumMatrix(arr);

        s.sumRegion(2, 1, 4, 3);
        s.sumRegion(1, 1, 2, 2);
        s.sumRegion(1, 2, 2, 4);
    }
}

class NumMatrix {

    int[][] sumMatrix;

    public NumMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        sumMatrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    sumMatrix[i][j] = mat[i][j];
                }
                else {
                    sumMatrix[i][j] = sumMatrix[i][j - 1] + mat[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if(col1 > 0) {
                sum += sumMatrix[i][col2] - sumMatrix[i][col1 - 1];
            } else{
                sum += sumMatrix[i][col2];
            }
        }

        return sum;
    }
}
