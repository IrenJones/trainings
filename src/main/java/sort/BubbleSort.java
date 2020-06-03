package sort;

public class BubbleSort {
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
		int temp;
		for(int i=0; i< n; i++){
			for(int j = 0; j < n-i-1; j++){
				if (arr[j] > arr[j+1]){
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	private static void reverseSortAlgo(int[] arr) {
		int n = arr.length;
		int temp;
		for(int i=0; i< n; i++){
			for(int j = 0; j < n-i-1; j++){
				if (arr[j] < arr[j+1]){
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
