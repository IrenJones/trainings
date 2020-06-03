package sort;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = new int[]{1,5,6,3,2,2,8,9,4,4,6};
		sortAlgo(arr);
		for(int v: arr){
			System.out.print(v + "  ");
		}
		System.out.println();

		reverseSortAlgo(arr);
		for(int v: arr){
			System.out.print(v + "  ");
		}
		System.out.println();
	}

	private static void sortAlgo(int[] arr) {
		int n = arr.length;
		for (int i = 0; i< n; i++){

			// Find the min element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	private static void reverseSortAlgo(int[] arr) {
		int n = arr.length;
		for (int i = 0; i< n; i++){

			// Find the max element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++) {
				if (arr[j] > arr[min_idx]) {
					min_idx = j;
				}
			}

			// Swap the found max element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
}
