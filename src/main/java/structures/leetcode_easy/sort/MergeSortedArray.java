package structures.leetcode_easy.sort;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] n = new int[]{1,3,5,0,0,0};
		mergeBetter(n, 3, new int[]{2,4,6}, 3);
		merge(new int[]{1,3,5,0,0,0}, 3, new int[]{2,4,6}, 3);
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int[] nums = new int[m];
		for(int i=0; i< m; i++){
			nums[i] = nums1[i];
		}
		int index = 0;
		int i = 0;
		int j = 0;

		while(i < m && j < n){
			if(nums[i] < nums2[j]){
				nums1[index] = nums[i];
				index++;
				i++;
			} else{
				nums1[index] = nums2[j];
				index++;
				j++;
			}
		}

		while(i < m){
			nums1[index] = nums[i];
			index++;
			i++;
		}

		while(j < n){
			nums1[index] = nums2[j];
			index++;
			j++;
		}
	}

	public static void mergeBetter(int[] nums1, int m, int[] nums2, int n) {

		int index = m + n -1;
		int i = m-1;
		int j = n-1;

		while(i >= 0 && j >= 0){
			if(nums1[i] > nums2[j]){
				nums1[index] = nums1[i];
				i--;
				index--;
			} else {
				nums1[index] = nums2[j];
				j--;
				index--;
			}
		}

		while (j >= 0){
			nums1[index] = nums2[j];
			j--;
			index--;
		}
	}
}
