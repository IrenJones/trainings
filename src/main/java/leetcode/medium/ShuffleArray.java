package leetcode.medium;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
	int size;
	int original[];
	int shuffled[];

	public static void main(String[] args) {
		ShuffleArray obj = new ShuffleArray(new int[]{1, 2, 3, 4, 5});
		int[] param_1 = obj.reset();
		int[] param_2 = obj.shuffle();
		int[] param_3 = obj.reset();
		System.out.println("Done!");
	}

	public ShuffleArray(int[] nums) {
		size = nums.length;
		original = Arrays.copyOf(nums, size);
		shuffled = new int[size];
	}

	/**
	 * Resets the array to its original configuration and return it.
	 */
	public int[] reset() {
		return Arrays.copyOf(original, size);
	}

	/**
	 * Returns a random shuffling of the array.
	 * Use Fisher-Yates Algorithm
	 */
	public int[] shuffle() {
		int tmp;
		Random r = new Random();
		shuffled = Arrays.copyOf(original, size);
		for (int j = 1; j < size; j++) {
			int i = r.nextInt(j + 1);
			tmp = shuffled[i];
			shuffled[i] = shuffled[j];
			shuffled[j] = tmp;
		}
		return shuffled;
	}
}
