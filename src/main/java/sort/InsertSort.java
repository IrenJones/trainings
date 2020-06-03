package sort;

public class InsertSort {
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
		for(int i=0; i < n; i++){
			int j = i-1;
			// keep selected value
			int key = arr[i];
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while (j >= 0 && key < arr[j]) {
				// move to right
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	private static void reverseSortAlgo(int[] arr) {
		int n = arr.length;
		for(int i=0; i < n; i++){
			int j = i-1;
			// keep selected value
			int key = arr[i];
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while (j >= 0 && key > arr[j]) {
				// move to right
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}
