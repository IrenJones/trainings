package leetcode.leetcode_by_topics.array;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] paths = new int[n][m];
        paths[0][0] = 1;

        // first row
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[0][j] == 1) {
                paths[0][j] = 0;
            }
            else {
                paths[0][j] = paths[0][j - 1];
            }
        }

        // first column
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[j][0] == 1) {
                paths[j][0] = 0;
            }
            else {
                paths[j][0] = paths[j - 1][0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                }
                else {
                    paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
                }
            }
        }

        return paths[n - 1][m - 1];
    }
}
