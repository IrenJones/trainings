package different_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(Arrays.asList(99, 99, 99, 99, 99, 99));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(66, 66, 66, 66, 66, 66));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(33, 33, 33, 33, 33, 33));
		List<Integer> l4 = new ArrayList<>(Arrays.asList(99, 99, 99, 99, 99, 99));
		List<Integer> l5 = new ArrayList<>(Arrays.asList(66, 66, 66, 66, 66, 66));
		List<Integer> l6 = new ArrayList<>(Arrays.asList(33, 33, 33, 33, 33, 33));
		List<List<Integer>> list = new ArrayList<>(Arrays.asList(l1, l2, l3, l4, l5, l6));
		System.out.println(isValidSudoku(list));
	}

	static boolean isValidSudoku(List<List<Integer>> puzzle) {
		boolean result = true;

		for (int i = 0; i < 6; i++) {
			if (!checkArray(createArrayForColumn(i, puzzle))) {
				result = false;
			}
		}

		for (int i = 0; i < 6; i++) {
			if (!checkArray(createArrayForRow(i, puzzle))) {
				result = false;
			}
		}
		return result;
	}

	static int[] createArrayForColumn(int i, List<List<Integer>> puzzle) {
		int[] res = new int[6];
		for (int j = 0; j < 6; j++) {
			res[j] = puzzle.get(j).get(i);
		}
		return res;
	}

	static int[] createArrayForRow(int i, List<List<Integer>> puzzle) {
		int[] res = new int[6];
		for (int j = 0; j < 6; j++) {
			res[j] = puzzle.get(i).get(j);
		}
		return res;
	}

	static boolean checkArray(int[] mas) {
		int gcdValue = mas[0];
		for (int i = 1; i < 6; i++) {
			gcdValue = gcd(mas[i], gcdValue);
			if (gcdValue == 1) {
				return false;
			}
		}
		return true;
	}

	static int gcd(int v1, int v2) {
		if (v1 == 0) {
			return v2;
		}
		return gcd(v2 % v1, v1);
	}
}
