package sort;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = new int[]{1, 5, 6, 3, 2, 2, 8, 9, 4, 4, 6};
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
		quickSort(arr, 0, n - 1);
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			        /* pi is partitioning index, arr[pi] is now
           at right place */
			int pivotIndex = partition(arr, left, right);

			quickSort(arr, left, pivotIndex - 1);  // Before pi
			quickSort(arr, pivotIndex + 1, right); // After pi
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int pivotIndex = (left + right)/2;
		int pivot = arr[pivotIndex];
		int indexLeft = left;
		int indexRight = right;

		while (indexLeft <= indexRight){
			while(arr[indexLeft] < pivot){
				indexLeft++;
			}
			while(arr[indexRight] > pivot){
				indexRight--;
			}
			if(indexLeft <= indexRight) {
				int temp = arr[indexLeft];
				arr[indexLeft] = arr[indexRight];
				arr[indexRight] = temp;
				indexLeft++;
				indexRight--;
			}
		}
		return indexLeft;
	}

	private static void reverseSortAlgo(int[] arr) {
		int n = arr.length;
		reverseQuickSort(arr, 0, n - 1);
	}

	private static void reverseQuickSort(int[] arr, int left, int right) {
		if (left < right) {
			        /* pi is partitioning index, arr[pi] is now
           at right place */
			int pivotIndex = reversePartition(arr, left, right);

			reverseQuickSort(arr, left, pivotIndex - 1);  // Before pi
			reverseQuickSort(arr, pivotIndex + 1, right); // After pi
		}
	}

	private static int reversePartition(int[] arr, int left, int right) {
		int pivotIndex = (left + right)/2;
		int pivot = arr[pivotIndex];
		int indexLeft = left;
		int indexRight = right;

		while (indexLeft <= indexRight){
			while(arr[indexLeft] > pivot){
				indexLeft++;
			}
			while(arr[indexRight] < pivot){
				indexRight--;
			}
			if(indexLeft <= indexRight) {
				int temp = arr[indexLeft];
				arr[indexLeft] = arr[indexRight];
				arr[indexRight] = temp;
				indexLeft++;
				indexRight--;
			}
		}
		return indexLeft;
	}
}
