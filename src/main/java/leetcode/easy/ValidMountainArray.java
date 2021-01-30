package leetcode.easy;

public class ValidMountainArray {

	public boolean validMountainArray(int[] arr) {
		int i = 0;
		int j = arr.length - 1;

		while(i < j) {
			if( i < arr.length - 1 && arr[i] < arr[i + 1]) {
				i++;
			}
			if( j > 0 && arr[j - 1] > arr[j]) {
				j--;
			}

			if(i == j && i > 0 && j < arr.length - 1) {
				return true;
			} else if(i < arr.length - 1 && arr[i] >= arr[i + 1] && j > 0 && arr[j - 1] <= arr[j]) {
					return false;
			}
		}
		return false;
	}

	public boolean validMountainArrayMoreLogical(int[] arr) {
		int i = 0;
		int n = arr.length;

		while(i + 1 < n && arr[i] < arr[i + 1]) {
			i++;
		}

		if(i == 0 || i == n - 1) {
			return false;
		}

		while(i + 1 < n && arr[i] > arr[i + 1]){
			i++;
		}

		return i == n - 1;
	}
}
