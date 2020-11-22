package leetcode.medium;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int end = nums.length - 1;
		int start = 0;

		while (start <= end) {
			int mid = (end + start) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			boolean isMidExists = existsInFirst(nums, start, nums[mid]);
			boolean isTargetExists = existsInFirst(nums, start, target);

			if (isMidExists ^ isTargetExists) {
				if (isMidExists) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (nums[mid] < target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	private static boolean existsInFirst(int[] nums, int start, int element) {
		return nums[start] <= element;
	}
}
