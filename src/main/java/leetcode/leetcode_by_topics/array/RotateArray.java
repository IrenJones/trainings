package leetcode.leetcode_by_topics.array;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		int tmp;
		int n = nums.length;
		if(n < 2 ){
			return;
		}
		k = k > n ? k - k/n*n : k;
		for(int i=0; i < k; i++){
			tmp = nums[n-1];
			for(int j=n-2; j>=0;j--){
				nums[j+1] = nums[j];
			}
			nums[0] = tmp;
		}
	}

	public static void main(String[] args) {
		rotateNew(new int[]{1,2,3,4,5,6,7}, 3);
	}

	public static void rotateNew(int[] nums, int k) {
		if(k == 0 || nums.length < 2) {
			return;
		}
		int steps = k % nums.length;

		reverseArray (nums, 0, nums.length -1);
		reverseArray (nums, 0, steps - 1);
		reverseArray (nums, steps, nums.length -1);
	}

	public static void reverseArray (int[] arr, int start, int finish) {
		int tmp;
		while(start < finish) {
			tmp = arr[start];
			arr[start] = arr[finish];
			arr[finish] = tmp;
			start++;
			finish--;
		}
	}
}
