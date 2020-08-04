package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][]{
				new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));

		System.out.println(isValidSudokuHashSetMethod(new char[][]{
				new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
	}

	public static boolean isValidSudoku(char[][] board) {
		Set<Character> setColumns = new HashSet<>();
		Set<Character> setRows = new HashSet<>();
		Set<Character> square = new HashSet<>();

		// check columns and rows
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// rows
				if (board[i][j] != '.' && setRows.contains(board[i][j])) {
					return false;
				} else if (board[i][j] != '.') {
					setRows.add(board[i][j]);
				}

				// columns
				if (board[j][i] != '.' && setColumns.contains(board[j][i])) {
					return false;
				} else if (board[j][i] != '.') {
					setColumns.add(board[j][i]);
				}
			}
			setColumns = new HashSet<>();
			setRows = new HashSet<>();
		}

		// check squares
		for (int i = 1; i < 9; i = i + 3) {
			for (int j = 1; j < 9; j = j + 3) {
				if (!trueSudokuSquare(board, square, i, j)) {
					return false;
				}
				square = new HashSet<>();
			}
		}

		return true;
	}

	private static boolean trueSudokuSquare(char[][] board, Set<Character> square, int centerI, int centerJ) {
		for (int i = centerI - 1; i <= centerI + 1; i++) {
			for (int j = centerJ - 1; j <= centerJ + 1; j++) {
				if (board[i][j] != '.' && square.contains(board[i][j])) {
					return false;
				} else if (board[i][j] != '.') {
					square.add(board[i][j]);
				}
			}
		}
		return true;
	}

	public static boolean isValidSudokuHashSetMethod(char[][] board) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char value = board[i][j];
				if (value != '.') {
					if (!set.add(value + " in row " + i) ||
							!set.add(value + " in column " + j) ||
							!set.add(value + " in box " + i / 3 + j / 3)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
