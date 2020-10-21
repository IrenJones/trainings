package leetcode.medium;

public class Search2DMatrix {

	public static void main(String[] args) {
		int [][] matrix = {};
		System.out.println(searchMatrix(matrix, 0) == false);
		int[][] matrix1 = {
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,50}
		};
		System.out.println(searchMatrix(matrix1, 13) == false);
		System.out.println(searchMatrix(matrix1, 16) == true);
		System.out.println(searchMatrix(matrix1, 23) == true);
		System.out.println(searchMatrix(matrix1, 26) == false);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) {
			return false;
		}
		if (matrix.length == 1 && matrix[0].length == 1) {
			return matrix[0][0] == target;
		}

		int iResult = binarySearchForVertical(matrix, target);
		if(iResult == -13) {
			// target is located in first column
			return true;
		}

		int jResult = binarySearchForHorizontal(matrix, target, iResult);
		return jResult == -13;
	}

	private static int binarySearchForHorizontal(int[][] matrix, int target, int iResult) {
		int index = 0;
		int maxIndex = matrix[0].length - 1;

		int middle;
		while(index <= maxIndex) {
			middle = index + (maxIndex - index)/2;
			if (matrix[iResult][middle] == target) {
				return -13;
			} else if (matrix[iResult][middle] < target) {
				index = middle + 1;
			} else {
				maxIndex = middle - 1;
			}
		}
		return maxIndex;
	}

	private static int binarySearchForVertical(int[][] matrix, int target) {
		int index = 0;
		int maxIndex = matrix.length - 1;

		int middle;
		while(index <= maxIndex) {
			middle = index + (maxIndex - index)/2;
			if (matrix[middle][0] == target) {
				return -13;
			} else if (matrix[middle][0] < target) {
				index = middle + 1;
			} else {
				maxIndex = middle - 1;
			}
		}
		return maxIndex;
	}
}
