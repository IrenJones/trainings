package leetcode.leetcode_by_topics.waterContainers;

public class TrappingRainWater {

	public int trap(int[] height) {
		int result = 0;
		for (int i = 0; i < height.length; i++) {
			int left = 0, right = 0;

			for(int j =0; j<= i; j++) {
				left = Math.max(left, height[j]);
			}

			for(int j =i; j< height.length; j++) {
				right = Math.max(right, height[j]);
			}

			result += Math.min(left, right) - height[i];
		}
		return result;
	}
}
