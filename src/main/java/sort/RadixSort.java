package sort;

import java.util.Arrays;

public class RadixSort {
	// Using counting sort to sort the elements in the basis of significant places
	public int[] countingSort(int arr[], int n, int place) {
		int output[] = new int[n]; // output array
		int count[] = new int[10];
		Arrays.fill(count,0);

		// Store count of occurrences in count[]
		for (int i = 0; i < n; i++) {
			int index = (arr[i] / place) % 10;
			count[index]++;
		}

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		// Build the output array
		for (int i = n - 1; i >= 0; i--)
		{
			int index = (arr[i]/place)%10;
			output[count[index] - 1] = arr[i];
			count[index]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to curent digit
		return output;
	}

	// Function to get the largest element from an array
	int getMax(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	// Main function to implement radix sort
	int[] radixSort(int arr[], int size) {
		// Get maximum element
		int max = getMax(arr, size);

		// Apply counting sort to sort elements based on place value.
		for (int place = 1; max / place > 0; place *= 10) {
			arr = countingSort(arr, size, place);
		}
		return arr;
	}

	// Driver code
	public static void main(String args[]) {
		int[] data = { 121, 432, 564, 23, 1, 45, 788 };
		int size = data.length;
		RadixSort rs = new RadixSort();
		data = rs.radixSort(data, size);
		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(data));
	}
}
