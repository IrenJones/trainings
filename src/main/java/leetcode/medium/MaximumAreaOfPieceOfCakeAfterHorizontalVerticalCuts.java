package leetcode.medium;

import java.util.Arrays;

public class MaximumAreaOfPieceOfCakeAfterHorizontalVerticalCuts {

	public static void main(String[] args) {
		System.out.println(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}) == 4);
	}

	public static int maxArea(int h, int w,
							  int[] horizontalCuts,
							  int[] verticalCuts) {

		if (h == 0 || w == 0 || horizontalCuts.length == 0 && verticalCuts.length == 0) {
			return h * w;
		}

		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		int maxH = 0;
		for (int i = 0; i < horizontalCuts.length + 1; i++) {
			if (i == horizontalCuts.length) {
				maxH = Math.max(maxH, h - horizontalCuts[i - 1]);
			} else if (horizontalCuts[i] != 0 && horizontalCuts[i] != h) {
				if (i == 0) {
					maxH = Math.max(maxH, horizontalCuts[i]);
				} else {
					maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
				}
			}
		}

		int maxW = 0;
		for (int i = 0; i < verticalCuts.length + 1; i++) {
			if (i == verticalCuts.length) {
				maxW = Math.max(maxW, w - verticalCuts[i - 1]);
			} else if (verticalCuts[i] != 0 && verticalCuts[i] != w) {
				if (i == 0) {
					maxW = Math.max(maxW,verticalCuts[i]);
				} else {
					maxW = Math.max(maxW,verticalCuts[i] - verticalCuts[i - 1]);
				}
			}
		}
		return (int)((long)maxH * maxW % 1000000007);
	}
}
