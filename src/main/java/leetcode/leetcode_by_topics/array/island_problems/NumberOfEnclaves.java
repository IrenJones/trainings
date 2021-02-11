package leetcode.leetcode_by_topics.array.island_problems;

public class NumberOfEnclaves {

	public static void main(String[] args) {
		NumberOfEnclaves solution = new NumberOfEnclaves();

		int[][] arr = {
				{0, 0, 0, 0},
				{1, 0, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 0}
		};

		System.out.println(solution.numEnclaves(arr));
	}

	public int numEnclaves(int[][] A) {
		if (A.length < 2 && A[0].length < 2) {
			return 0;
		}

		int result = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if(i == 0 || j == 0 || i == A.length - 1 || j == A[i].length - 1) {
					track(A, i, j);
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					result++;
				}
			}
		}

		return result;
	}

	public void track(int a[][], int i, int j) {
		if(i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
			a[i][j] = 0;
			track(a, i + 1, j);
			track(a, i - 1, j);
			track(a, i, j + 1);
			track(a, i, j - 1);
		}
	}
}
