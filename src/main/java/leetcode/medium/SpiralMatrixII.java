package leetcode.medium;

public class SpiralMatrixII {

	public static void main(String[] args) {
		generateMatrix(1);
		generateMatrix(3);
	}

	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];

		for(int i=0; i< n; i++) {
			res[i] = new int[n];
		}

		int current = 1;
		int iMin = 0, jMin = 0, iMax = n - 1, jMax = n - 1;

		while (current <= n * n) {
			for(int j = jMin; j <= jMax; j++) {
				res[iMin][j] = current;
				current++;
			}
			for(int i = iMin + 1; i <= iMax; i++) {
				res[i][jMax] = current;
				current++;
			}
			for(int j = jMax - 1; j >= jMin; j--) {
				res[iMax][j] = current;
				current++;
			}
			for(int i = iMax - 1; i >= iMin + 1; i--) {
				res[i][jMin] = current;
				current++;
			}
			iMin++;
			iMax--;
			jMin++;
			jMax--;
		}

		return res;
	}
}
