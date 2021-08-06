package leetcode.leetcode_by_topics.array;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int value = 1;
        int round = 0;
        int[][] arr = new int[n][n];

        while (value <= n * n) {
            for (int i = round; i < n - round && value <= n * n; i++) {
                arr[round][i] = value++;
            }

            for (int i = round + 1; i < n - round && value <= n * n; i++) {
                arr[i][n - round - 1] = value++;
            }

            for (int i = n - round - 2; i >= round && value <= n * n; i--) {
                arr[n - round - 1][i] = value++;
            }

            for (int i = n - round - 2; i >= round + 1 && value <= n * n; i--) {
                arr[i][round] = value++;
            }

            round++;
        }

        return arr;
    }
}
