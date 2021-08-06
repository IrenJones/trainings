package leetcode.medium.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix {

	public static void main(String[] args) {
		int[][] m = {
			{0, 0, 0},
			{0, 1, 0},
			{1, 1, 1}
		};
		updateMatrixAgain(m);

		int[][] mas = {
				{0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
				{1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
				{1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
				{0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
				{1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
				{0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
				{1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
				{1, 0, 1, 1, 1, 0, 1, 1, 1, 0}
		};

		updateMatrix(mas);
	}

	public static int[][] updateMatrixAgain(int[][] mat) {
		if(mat.length == 1 && mat[0].length == 1){
			return mat;
		}
		int n = mat.length;
		int m = mat[0].length;

		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(mat[i][j] == 0){
					visited[i][j] = true;
					q.add(new int[]{i, j});
				}
			}
		}

		while(!q.isEmpty()){
			int[] cell = q.poll();
			int i = cell[0];
			int j = cell[1];
			checkCell(mat[i][j], i - 1, j, mat, visited, q, n, m);
			checkCell(mat[i][j], i + 1, j, mat, visited, q, n, m);
			checkCell(mat[i][j], i, j - 1, mat, visited, q, n, m);
			checkCell(mat[i][j], i, j + 1, mat, visited, q, n, m);
		}

		return mat;
	}

	private static void checkCell(int v, int i, int j, int[][] mat, boolean[][] visited, Queue<int[]> q, int n, int m) {
		if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j]){
			return;
		}

		visited[i][j] = true;
		mat[i][j] = v + 1;
		q.add(new int[]{i, j});
	}

	public static int[][] updateMatrix(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		Queue<Cell> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					visited[i][j] = true;
					q.add(new Cell(i, j));
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		while (!q.isEmpty()) {
			Cell cell = q.poll();
			// around the cell
			for (int[] d : dir) {
				int x = cell.x + d[0];
				int y = cell.y + d[1];

				if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
					continue;
				} else {
					visited[x][y] = true;
					matrix[x][y] = matrix[cell.x][cell.y] + 1;
					q.add(new Cell(x, y));
				}
			}
		}

		return matrix;
	}


	static class Cell {
		int x;
		int y;

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
