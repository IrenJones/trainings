package leetcode.leetcode_by_topics.array;

public class CountNegativeNumbersInSortedMatrix {

    int count;

    public int countNegatives(int[][] grid) {
        count = 0;
        countNeg(grid, grid.length - 1, grid[0].length - 1, grid.length, grid[0].length);
        return count;
    }

    public void countNeg(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] >= 0) {
            return;
        }
        count++;
        grid[i][j] = -grid[i][j];
        countNeg(grid, i + 1, j, n, m);
        countNeg(grid, i - 1, j, n, m);
        countNeg(grid, i, j + 1, n, m);
        countNeg(grid, i, j - 1, n, m);
    }

    public int countNegativesFaster(int[][] grid) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (grid[i][j] < 0) {
                count += n - i;
                j--;
            }
            else {
                i++;
            }
        }

        return count;
    }
}
