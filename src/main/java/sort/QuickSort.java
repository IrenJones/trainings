package sort;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        quicksort(nums, 0, nums.length - 1);

        return nums;
    }

    public void quicksort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quicksort(arr, low, j);
        }

        if (high > i) {
            quicksort(arr, i, high);
        }
    }
}
