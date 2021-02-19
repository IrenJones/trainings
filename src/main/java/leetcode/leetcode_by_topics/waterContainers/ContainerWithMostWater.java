package leetcode.leetcode_by_topics.waterContainers;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int maxArea = 0;
		int minH;
		while(i < j) {
			if(height[i] > height[j]) {
				minH = height[j];
				j--;
			} else {
				minH = height[i];
				i++;
			}
			maxArea = Math.max(maxArea,  (j - i + 1) * minH);
		}

		return maxArea;
	}
}
