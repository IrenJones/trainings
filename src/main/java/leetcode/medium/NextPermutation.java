package leetcode.medium;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int indexFirst = -1;

		for(int i= nums.length - 1; i > 0; i--) {
			if(nums[i] > nums[i-1]) {
				indexFirst = i -1;
				break;
			}
		}

		if(indexFirst > -1) {
			for(int i= nums.length - 1; i > 0; i--) {
				if(nums[i] > nums[indexFirst]) {
					swap(nums, indexFirst, i);
					break;
				}
			}
		}

		// order part after indexFirst
		int smallest;
		for(int i = indexFirst + 1; i < nums.length; i++) {
			smallest = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[smallest] > nums[j]) {
					smallest = j;
				}
			}
			swap(nums, i, smallest);
		}
	}

	public void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
