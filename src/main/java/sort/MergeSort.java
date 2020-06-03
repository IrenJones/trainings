package sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 5, 6, 3, 2, 2, 8, 9, 4, 4, 6};
		sortAlgo(arr);
		for (int v : arr) {
			System.out.print(v + "  ");
		}
		System.out.println();

		reverseSortAlgo(arr);
		for (int v : arr) {
			System.out.print(v + "  ");
		}
		System.out.println();
	}

	private static void sortAlgo(int[] arr) {
		int n = arr.length;
		splitArr(arr, 0, n - 1);
	}

	private static void splitArr(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (right + left) / 2;
			splitArr(arr, left, mid);
			splitArr(arr, mid + 1, right);
			mergeArr(arr, left, right, mid);
		}
	}

	private static void mergeArr(int[] arr, int left, int right, int mid) {

		// Find sizes of two subarrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];
		// copy
		for (int i = 0; i < n1; i++) {
			leftArray[i] = arr[left + i];
		}
		for (int i = 0; i < n2; i++) {
			rightArray[i] = arr[mid + 1 + i];
		}

		/* Merge arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int index = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[index] = leftArray[i];
				i++;
			} else {
				arr[index] = rightArray[j];
				j++;
			}
			index++;
		}

		/* Copy remaining elements */
		while (i < n1) {
			arr[index] = leftArray[i];
			i++;
			index++;
		}
		while (j < n2) {
			arr[index] = rightArray[j];
			j++;
			index++;
		}
	}

	private static void reverseSortAlgo(int[] arr) {
		int n = arr.length;
		reverseSplitArr(arr, 0, n - 1);
	}

	private static void reverseSplitArr(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (right + left) / 2;
			reverseSplitArr(arr, left, mid);
			reverseSplitArr(arr, mid + 1, right);
			reverseMergeArr(arr, left, right, mid);
		}
	}

	private static void reverseMergeArr(int[] arr, int left, int right, int mid) {

		// Find sizes of two subarrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];
		// copy
		for (int i = 0; i < n1; i++) {
			leftArray[i] = arr[left + i];
		}
		for (int i = 0; i < n2; i++) {
			rightArray[i] = arr[mid + 1 + i];
		}

		/* Merge arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int index = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] > rightArray[j]) {
				arr[index] = leftArray[i];
				i++;
			} else {
				arr[index] = rightArray[j];
				j++;
			}
			index++;
		}

		/* Copy remaining elements */
		while (i < n1) {
			arr[index] = leftArray[i];
			i++;
			index++;
		}
		while (j < n2) {
			arr[index] = rightArray[j];
			j++;
			index++;
		}
	}
}
