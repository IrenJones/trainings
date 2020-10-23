package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix {
	public static void main(String[] args) {
		int[][] arr = {
				{1,10,4,2},
				{9,3,8,7},
				{15,16,17,12}
		};
		luckyNumbers(arr);
	}

	public static List<Integer> luckyNumbers (int[][] matrix) {
		List<Integer> luckyRow = new ArrayList<>();
		List<Integer> luckyColumn = new ArrayList<>();

		for(int i=0; i< matrix.length; i++) {
			luckyRow.add(findMin(matrix[i]));
		}
		for(int i=0; i< matrix[0].length; i++) {
			luckyColumn.add(findMax(matrix, i));
		}

		luckyColumn.retainAll(luckyRow);
		return luckyColumn;
	}

	private static int findMax(int[][] matrix, int column) {
		int result = matrix[0][column];
		for(int i=1; i< matrix.length; i++) {
			if(matrix[i][column] > result) {
				result = matrix[i][column];
			}
		}
		return result;
	}

	private static int findMin(int[] matrix) {
		int result = matrix[0];
		for(int i=1; i< matrix.length; i++) {
			if(matrix[i] < result) {
				result = matrix[i];
			}
		}
		return result;
	}
}
