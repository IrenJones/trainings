package leetcode.medium;

public class SearchInRotatedSortedArray2 {

	public boolean search(int[] nums, int target) {
		if (nums.length == 1) {
			return nums[0] == target;
		}

		int end = nums.length - 1;
		int start = 0;

		while (start <= end) {
			int mid = (start + end) / 2;

			if(nums[mid] == target) {
				return true;
			}

			if(!isBinarySearchIsUseful(nums, start, mid)) {
				start++;
				continue;
			}

			boolean isMidInFirstPart = checkIfInFirstPart(nums, start, nums[mid]);
			boolean isTargetInFirstPart = checkIfInFirstPart(nums, start, target);

			if(!isMidInFirstPart && isTargetInFirstPart) {
				end = mid - 1;
			} else if(isMidInFirstPart && !isTargetInFirstPart) {
				start = mid + 1;
			} else {
				// both together
				if (nums[mid] < target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return false;
	}

	private boolean checkIfInFirstPart(int[] nums, int start, int value) {
		return nums[start] <= value;
	}

	private boolean isBinarySearchIsUseful(int[] nums, int start, int mid) {
		return nums[start] != nums[mid];
	}

}
