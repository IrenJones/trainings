package structures.leetcode_easy.array;

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
}
