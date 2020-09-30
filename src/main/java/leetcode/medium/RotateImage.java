package leetcode.medium;

public class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		matrix[0] = new int[]{1, 2, 3};
		matrix[1] = new int[]{4, 5, 6};
		matrix[2] = new int[]{7, 8, 9};

		rotate(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix) {
		int size = matrix.length;

		// transpose matrix
		for(int i=0; i< size; i++){
			for(int j=i+1; j< size; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

		// change columns
		for(int j=0; j< size/2; j++){
			for(int i=0; i< size; i++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][size-1-j];
				matrix[i][size-1-j] = tmp;
			}
		}
	}
}
