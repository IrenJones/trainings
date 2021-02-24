package leetcode.medium;

public class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int n = matrix.length;
		int m = matrix[0].length;

		if(target < matrix[0][0] || target > matrix[n-1][m-1]) {
			return false;
		}

		for (int i = 0; i< n; i++) {
			if(matrix[i][0] <= target && matrix[i][m-1] >= target) {
				if(inRow(matrix, i, target)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean inRow(int[][] matrix, int i, int target) {
		int left = 0;
		int right = matrix[0].length - 1;

		while (left <= right) {
			int mid = left + (right - left)/2;
			if(matrix[i][mid] == target) {
				return true;
			}
			if (matrix[i][mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}


	public boolean searchMatrixBetter(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int n = matrix.length;
		int m = matrix[0].length;

		if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
			return false;
		}

		// choose start point - right upper corner
		int j = m - 1;
		int i = 0;

		while (i < n && j >= 0) {
			if(matrix[i][j] == target) {
				return true;
			}

			if(matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}

		return false;
	}
}
