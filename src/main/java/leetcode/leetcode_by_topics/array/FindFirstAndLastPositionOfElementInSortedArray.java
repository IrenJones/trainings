package leetcode.leetcode_by_topics.array;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray s = new FindFirstAndLastPositionOfElementInSortedArray();
        s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
    }

    // ok, but not very cute

    int start = Integer.MAX_VALUE;
    int end = Integer.MIN_VALUE;

    public int[] searchRange(int[] nums, int target) {

        binary(0, nums.length - 1, nums, target);

        if (start == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }

        return new int[] {start, end};
    }

    public void binary(int i, int j, int[] nums, int target) {
        if (i <= j) {
            int mid = (j + i) / 2;
            if (nums[mid] < target) {
                binary(mid + 1, j, nums, target);
            }
            else if (nums[mid] > target) {
                binary(i, mid - 1, nums, target);
            }
            else {
                start = Math.min(start, mid);
                end = Math.max(end, mid);
                binary(i, mid - 1, nums, target);
                binary(mid + 1, j, nums, target);
            }
        }
    }

    // better

    public int[] searchRangeBetter(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int start = binaryFirst(0, nums.length, nums, target);

        if (start == nums.length || nums[start] != target) {
            return new int[] {-1, -1};
        }

        int end = binaryFirst(0, nums.length, nums, target + 1);

        return new int[] {start, end - 1};
    }

    public int binaryFirst(int i, int j, int[] nums, int target) {

        while (i < j) {
            int mid = (j + i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            }
            else {
                j = mid;
            }
        }

        return i;
    }

}
