package leetcode.leetcode_by_topics.array;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSums {

	//Given an array of integers, return an list of integers which contains the
	//[1st integer, Sum of next 2 integers (2nd, 3rd),
	//Sum of next 3 integers (4th, 5th, 6th)…] and so on
	//Input
	//[1,6,8,5,9,4,7,2]
	//	Output
	//[1,14,18,9]

	public static void main(String[] args) {
		System.out.println(summationAgain(new int[]{1, 6, 8, 5, 9, 4, 7, 2}));
	}

	private static List<Integer> summation(int[] arr) {
		List<Integer> result = new ArrayList<>();
		int index = 0;
		int size = 1;
		int sum;
		while (index < arr.length) {
			sum = 0;
			for (int j = 0; j < size && index + j < arr.length; j++) {
				sum += arr[index + j];
			}
			result.add(sum);
			index += size;
			size++;
		}
		return result;
	}

	private static List<Integer> summationAgain(int[] arr) {
		List<Integer> list = new ArrayList<>();

		int size = 1;
		int index = 0;

		while(index < arr.length){
			int sum = 0;
			for(int i = index; i < arr.length && i < size + index; i++){
				sum += arr[i];
			}
			list.add(sum);
			index += size;
			size++;
		}

		return list;
	}
}
