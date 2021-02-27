package leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForGivenEquation {

	public List<List<Integer>> findSolutionBF(CustomFunction customfunction, int z) {
		int N = 1000;
		List<List<Integer>> result = new ArrayList<>();

		for(int i = 1; i < N; i++) {
			for(int j = 1; j < N; j++) {
				if(customfunction.f(i, j) == z) {
					result.add(Arrays.asList(i,j));
				} else if(customfunction.f(i, j) > z) {
					break;
				}
			}
		}

		return result;
	}

	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		int i = 1;
		int j = 1000;
		List<List<Integer>> result = new ArrayList<>();

		while(i <= 1000 && j > 0) {
			int value = customfunction.f(i,j);
			if(value > z) {
				j--;
			} else if(value < z) {
				i++;
			} else {
				result.add(Arrays.asList(i,j));
				i++;
				j--;
			}
		}
		return result;
	}

	class CustomFunction {
		 public int f(int x, int y){
		 	return 0;
		 };
  };
}
