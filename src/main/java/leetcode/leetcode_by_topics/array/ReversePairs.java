package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class ReversePairs {

    public static void main(String[] args) {
        ReversePairs solution = new ReversePairs();
        solution.reversePairs(new int[] {1, 3, 2, 3, 1});
    }

    // TLE
    public int reversePairsWorst(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((long)nums[i] > (long)2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // TLE
    public int reversePairs(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = (l + r) / 2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);

        for (int i = l; i <= mid; i++) {
            int j = mid + 1;
            int cnt = 0;
            while (j <= r && nums[i] / 2.0 > nums[j]) {
                j++;
                cnt++;
            }
            count += cnt;
        }

        //Arrays.sort(nums, l, r + 1);
        actualMerge(nums, l, mid, r);

        return count;
    }

    public void actualMerge(int[] nums, int l, int mid, int r) {
//        int[] left = Arrays.copyOfRange(nums, l, mid + 1);
        int[] left = new int[mid - l + 1];
        int ii = 0;
        for (int i = l; i <= mid; i++) {
            left[ii++] = nums[i];
        }
        //int[] right = Arrays.copyOfRange(nums, mid + 1, r + 1);
        int[] right = new int[r - mid];
        ii = 0;
        for (int i = mid + 1; i <= r; i++) {
            right[ii++] = nums[i];
        }

        int i = 0, j = 0;
        int index = l;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[index++] = left[i++];
            }
            else {
                nums[index++] = right[j++];
            }
        }

        while (i < left.length) {
            nums[index++] = left[i++];
        }

        while (j < right.length) {
            nums[index++] = right[j++];
        }
    }

    // works, but absolutely awful
    int count;

    public int reversePairsWorks(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        count = 0;
        mergeSortArr(nums, 0, nums.length - 1);
        return count;
    }

    public int[] mergeSortArr(int[] nums, int l, int r) {
        if (l == r) {
            return new int[] {nums[l]};
        }

        int mid = (l + r) / 2;

        int[] left = mergeSortArr(nums, l, mid);
        int[] right = mergeSortArr(nums, mid + 1, r);

        int i = 0, j = 0;
        while (j < right.length) {
            while (i < left.length && left[i] / 2.0 <= right[j]) {
                i++;
            }
            count += (left.length - i);
            j++;
        }

        return actualMerge(left, right);
    }

    public int[] actualMerge(int[] left, int[] right) {
        int[] nums = new int[left.length + right.length];

        int i = 0, j = 0;
        int index = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[index++] = left[i++];
            }
            else {
                nums[index++] = right[j++];
            }
        }

        while (i < left.length) {
            nums[index++] = left[i++];
        }

        while (j < right.length) {
            nums[index++] = right[j++];
        }

        return nums;
    }

    // perfect working piece of
    public int reversePairsFinal(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        return mergeSortFinal(nums, 0, nums.length - 1);
    }

    public int mergeSortFinal(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = (l + r) / 2;
        int count = mergeSortFinal(nums, l, mid) + mergeSortFinal(nums, mid + 1, r);

        int i = l, j = mid + 1;
        while (j <= r) {
            while (i <= mid && nums[i] / 2.0 <= nums[j]) {
                i++;
            }
            count += mid - i + 1;
            j++;
        }

        //Arrays.sort(nums, l, r + 1);
        actualMergeFinal(nums, l, mid, r);

        return count;
    }

    public void actualMergeFinal(int[] nums, int l, int mid, int r) {
//        int[] left = Arrays.copyOfRange(nums, l, mid + 1);
        int[] left = new int[mid - l + 1];
        int ii = 0;
        for (int i = l; i <= mid; i++) {
            left[ii++] = nums[i];
        }
        //int[] right = Arrays.copyOfRange(nums, mid + 1, r + 1);
        int[] right = new int[r - mid];
        ii = 0;
        for (int i = mid + 1; i <= r; i++) {
            right[ii++] = nums[i];
        }

        int i = 0, j = 0;
        int index = l;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[index++] = left[i++];
            }
            else {
                nums[index++] = right[j++];
            }
        }

        while (i < left.length) {
            nums[index++] = left[i++];
        }

        while (j < right.length) {
            nums[index++] = right[j++];
        }
    }
}
