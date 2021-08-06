package leetcode.leetcode_by_topics.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf s = new CountOfSmallerNumbersAfterSelf();
        s.countSmaller(new int[] {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41});
    }

    // TLE
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int v = nums[i];
            Arrays.sort(nums, i, n);
            int index = first(nums, i, n - 1, v, i);

            arr[i] = index - i;
        }

        return Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int first(int arr[], int l, int r, int v, int below) {
        if (r >= l) {
            int mid = (l + r) / 2;
            if ((mid == below || v > arr[mid - 1]) && arr[mid] == v) {
                return mid;
            }
            else if (v > arr[mid]) {
                return first(arr, mid + 1, r, v, below);
            }
            else {
                return first(arr, l, mid - 1, v, below);
            }
        }
        return -1;
    }

}
